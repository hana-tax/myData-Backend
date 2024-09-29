package com.example.mydata.domain.mydata.service;

import com.example.mydata.domain.publicOffice.dto.PublicDTO;
import com.example.mydata.domain.bank.dto.BankDTO;
import com.example.mydata.domain.card.dto.CardDTO;
import com.example.mydata.domain.insurance.dto.InsuranceDTO;
import com.example.mydata.domain.invest.dto.InvestDTO;
import com.example.mydata.domain.loan.dto.LoanDTO;
import com.example.mydata.domain.mydata.dto.MyDataEnrollmentRequest;
import com.example.mydata.domain.mydata.mapper.CodeMapper;
import com.example.mydata.domain.pension.dto.PensionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;  // 수정된 부분
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    private Date convertToLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        // UTC에서 로컬 시간으로 변환
        ZonedDateTime utcDateTime = date.toInstant().atZone(ZoneId.of("UTC"));
        ZonedDateTime localDateTime = utcDateTime.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
        System.out.println("UTC Date: " + utcDateTime);
        System.out.println("Local Date: " + localDateTime);
        return Date.from(localDateTime.toInstant());
    }

    public List<Object> processUserData(String accessToken, MyDataEnrollmentRequest request) {
        List<Object> assets = new ArrayList<>();
        String ci = request.getCi();
        List<Integer> assetCodes = request.getAssetCodes();

        for (Integer assetCode : assetCodes) {
            String codeCategory = codeMapper.getCodeCategoryByCode(assetCode);

            switch (codeCategory) {
                case "은행 코드":
                    List<BankDTO> bankData = fetchBankData(ci, assetCode,accessToken);
                    if (bankData != null) {
                        assets.addAll(bankData);
                    }
                    break;
                case "카드 코드":
                    List<CardDTO> cardData = fetchCardData(ci, assetCode,accessToken);
                    if (cardData != null) {
                        assets.addAll(cardData);
                    }
                    break;
                case "기타 금융 코드":
                    List<LoanDTO> loanData = fetchLoanData(ci, assetCode,accessToken);
                    if (loanData != null) {
                        assets.addAll(loanData);
                    }
                    break;
                case "증권 코드":
                    List<InvestDTO> investData = fetchInvestData(ci, assetCode,accessToken);
                    if (investData != null) {
                        assets.addAll(investData);
                    }
                    break;
                case "보험 코드":
                    List<InsuranceDTO> insuranceData = fetchInsuranceData(ci, assetCode,accessToken);
                    if (insuranceData != null) {
                        assets.addAll(insuranceData);
                    }
                    break;
                case "연금 코드":
                    List<PensionDTO> pensionData = fetchPensionData(ci, assetCode,accessToken);
                    if (pensionData != null) {
                        assets.addAll(pensionData);
                    }
                    break;
                case "공공기관 코드":
                    List<PublicDTO> publicData = fetchPublicData(ci, assetCode,accessToken);
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
    private List<BankDTO> fetchBankData(String userCi, int bankCode, String accessToken) {
        String url = "http://localhost:8081/api/bank?userCi=" + userCi + "&bankCode=" + bankCode;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<BankDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<BankDTO>>() {}
        );
        List<BankDTO> bankData = response.getBody();
        if (bankData != null) {
            for (BankDTO bank : bankData) {
                bank.setInterestDate(convertToLocalDate(bank.getInterestDate()));
                bank.setDividendDate(convertToLocalDate(bank.getDividendDate()));
            }
        }
        return bankData;
    }

    private List<CardDTO> fetchCardData(String userCi, int cardCode, String accessToken) {
        String url = "http://localhost:8081/api/card?userCi=" + userCi + "&cardCode=" + cardCode;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<CardDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<CardDTO>>() {}
        );

        return response.getBody();
    }

    private List<LoanDTO> fetchLoanData(String userCi, int loanCode, String accessToken) {
        String url = "http://localhost:8081/api/loan?userCi=" + userCi + "&loanCode=" + loanCode;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<LoanDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<LoanDTO>>() {}
        );

        return response.getBody();
    }

    private List<InvestDTO> fetchInvestData(String userCi, int investCode, String accessToken) {
        String url = "http://localhost:8081/api/invest?userCi=" + userCi + "&investCode=" + investCode;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<InvestDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<InvestDTO>>() {}
        );
        List<InvestDTO> investData = response.getBody();
        if (investData != null) {
            for (InvestDTO invest : investData) {
                invest.setDividendDate(convertToLocalDate(invest.getDividendDate()));
            }
        }
        return investData;
    }


    private List<InsuranceDTO> fetchInsuranceData(String userCi, int insuranceCode, String accessToken) {
        String url = "http://localhost:8081/api/insurance?userCi=" + userCi + "&insuranceCode=" + insuranceCode;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<InsuranceDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<InsuranceDTO>>() {}
        );

        return response.getBody();
    }
    private List<PensionDTO> fetchPensionData(String userCi, int pensionCode, String accessToken) {
        String url = "http://localhost:8081/api/pension?userCi=" + userCi + "&pensionCode=" + pensionCode;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<PensionDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<PensionDTO>>() {}
        );

        return response.getBody();
    }

    private List<PublicDTO> fetchPublicData(String userCi, int publicCode, String accessToken) {
        String url = "http://localhost:8081/api/public?userCi=" + userCi + "&publicCode=" + publicCode;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<PublicDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<PublicDTO>>() {}
        );

        return response.getBody();
    }

}
