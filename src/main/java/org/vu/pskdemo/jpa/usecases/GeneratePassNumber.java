package org.vu.pskdemo.jpa.usecases;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.vu.pskdemo.jpa.interceptors.LoggedInvocation;
import org.vu.pskdemo.jpa.services.pass.PassNumberGenerator;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GeneratePassNumber implements Serializable {
    @Inject
    PassNumberGenerator passNumberGenerator;

    private CompletableFuture<Integer> passNumberGeneratorTask = null;

    @LoggedInvocation
    public String generateNewPassNumber() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        passNumberGeneratorTask = CompletableFuture.supplyAsync(() -> passNumberGenerator.generatePassNumber());

        return  "/studentDetails.xhtml?faces-redirect=true&studentId=" + requestParameters.get("studentId");
    }

    public boolean isPassGenerationRunning() {
        return passNumberGeneratorTask != null && passNumberGeneratorTask.isDone();
    }

    public String getPassGenerationStatus() throws ExecutionException, InterruptedException {
        if (passNumberGeneratorTask == null) {
            return null;
        } else if (isPassGenerationRunning()) {
            return "Pass number generation in progress";
        }
        Integer passNumber = passNumberGeneratorTask.get();
        passNumberGeneratorTask = null;
        return "Suggested pass number: " + passNumber + " ";
    }
}