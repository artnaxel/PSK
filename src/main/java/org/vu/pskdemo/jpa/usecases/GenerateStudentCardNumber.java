package org.vu.pskdemo.jpa.usecases;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.vu.pskdemo.jpa.interceptors.LoggedInvocation;
import org.vu.pskdemo.jpa.services.CardNumberGenerator;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateStudentCardNumber implements Serializable {
    @Inject
    private CardNumberGenerator cardNumberGenerator;

    private CompletableFuture<Integer> cardNumberGenerationTask = null;

    @LoggedInvocation
    public String generateNewCardNumber() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        cardNumberGenerationTask = CompletableFuture.supplyAsync(() -> cardNumberGenerator.generateCardNumber());

        return  "/studentDetails.xhtml?faces-redirect=true&studentId=" + requestParameters.get("studentId");
    }

    public boolean isCardGenerationRunning() {
        return cardNumberGenerationTask != null && cardNumberGenerationTask.isDone();
    }

    public String getCardGenerationStatus() throws ExecutionException, InterruptedException {
        if (cardNumberGenerationTask == null) {
            return null;
        } else if (isCardGenerationRunning()) {
            return "Card number generation in progress";
        }
        return "Suggested card number: " + cardNumberGenerationTask.get();
    }
}