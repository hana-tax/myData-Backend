package com.example.mydata.domain.mydata.service;

import com.example.mydata.domain.PublicDTO;
import com.example.mydata.domain.bank.dto.BankDTO;
import com.example.mydata.domain.card.dto.CardDTO;
import com.example.mydata.domain.insurance.dto.InsuranceDTO;
import com.example.mydata.domain.invest.dto.InvestDTO;
import com.example.mydata.domain.loan.dto.LoanDTO;
import com.example.mydata.domain.mydata.dto.MyDataEnrollmentRequest;
import com.example.mydata.domain.mydata.mapper.CodeMapper;
import com.example.mydata.domain.pension.dto.PensionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MyDataProcessingService {
    private final RestTemplate restTemplate;
    private final CodeMapper codeMapper;
    @Autowired
    public MyDataProcessingService(RestTemplate restTemplate, CodeMapper codeMapper) {
        this.restTemplate = restTemplate;
        this.codeMapper = codeMapper;
    }

    public List<Object> processUserData(MyDataEnrollmentRequest request) {
        List<Object> assets = new ArrayList<>();
        String ci = request.getCi();
        List<Integer> assetCodes = request.getAssetCodes();

        for (Integer assetCode : assetCodes) {
            String codeCategory = codeMapper.getCodeCategoryByCode(assetCode);

            switch (codeCategory) {
                case "은행 코드":
                    List<BankDTO> bankData = fetchBankData(ci, assetCode);
                    if (bankData != null) {
                        assets.addAll(bankData);
                    }
                    break;
                case "카드 코드":
                    List<CardDTO> cardData = fetchCardData(ci, assetCode);
                    if (cardData != null) {
                        assets.addAll(cardData);
                    }
                    break;
                case "기타 금융 코드":
                    List<LoanDTO> loanData = fetchLoanData(ci, assetCode);
                    if (loanData != null) {
                        assets.addAll(loanData);
                    }
                    break;
                case "증권 코드":
                    List<InvestDTO> investData = fetchInvestData(ci, assetCode);
                    if (investData != null) {
                        assets.addAll(investData);
                    }
                    break;
                case "보험 코드":
                    List<InsuranceDTO> insuranceData = fetchInsuranceData(ci, assetCode);
                    if (insuranceData != null) {
                        assets.addAll(insuranceData);
                    }
                    break;
                case "연금 코드":
                    List<PensionDTO> pensionData = fetchPensionData(ci, assetCode);
                    if (pensionData != null) {
                        assets.addAll(pensionData);
                    }
                    break;
                case "공공기관 코드":
                    List<PublicDTO> publicData = fetchPublicData(ci, assetCode);
                    if (publicData != null) {
                        assets.addAll(publicData);
                    }
                    break;
                default:
                    System.out.println("Unknown code category: " + codeCategory);
            }
        }

        return assets;
    }
    private List<BankDTO> fetchBankData(String userCi, int bankCode) {
        String url = "http://localhost:8081/api/bank?userCi=" + userCi + "&bankCode=" + bankCode;
        List<BankDTO> response = restTemplate.getForObject(url, List.class);
        System.out.println("Bank Data: " + response);
        return response;
    }

    private List<CardDTO> fetchCardData(String userCi, int cardCode) {
        String url = "http://localhost:8081/api/card?userCi=" + userCi + "&cardCode=" + cardCode;
        List<CardDTO> response = restTemplate.getForObject(url, List.class);
        System.out.println("Card Data: " + response);
        return response;
    }

    private List<LoanDTO> fetchLoanData(String userCi, int loanCode) {
        String url = "http://localhost:8081/api/loan?userCi=" + userCi + "&loanCode=" + loanCode;
        List<LoanDTO> response = restTemplate.getForObject(url, List.class);
        System.out.println("Loan Data: " + response);
        return response;
    }

    private List<InvestDTO> fetchInvestData(String userCi, int investCode) {
        String url = "http://localhost:8081/api/invest?userCi=" + userCi + "&investCode=" + investCode;
        List<InvestDTO> response = restTemplate.getForObject(url, List.class);
        System.out.println("Invest Data: " + response);
        return response;
    }


    private List<InsuranceDTO> fetchInsuranceData(String userCi, int insuranceCode) {
        String url = "http://localhost:8081/api/insurance?userCi=" + userCi + "&insuranceCode=" + insuranceCode;
        List<InsuranceDTO> response = restTemplate.getForObject(url, List.class);
        System.out.println("Insurance Data: " + response);
        return response;
    }
    private List<PensionDTO> fetchPensionData(String userCi, int pensionCode) {
        String url = "http://localhost:8081/api/pension?userCi=" + userCi + "&pensionCode=" + pensionCode;
        List<PensionDTO> response = restTemplate.getForObject(url, List.class);
        System.out.println("Pension Data: " + response);
        return response;
    }

    private List<PublicDTO> fetchPublicData(String userCi, int publicCode) {
        String url = "http://localhost:8081/api/public?userCi=" + userCi + "&publicCode=" + publicCode;
        List<PublicDTO> response = restTemplate.getForObject(url, List.class);
        System.out.println("Public Data: " + response);
        return response;
    }

}
