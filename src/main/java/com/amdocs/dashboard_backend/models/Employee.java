package com.amdocs.dashboard_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.List;

@Document
public class Employee {
    @Id
    private String empId;
    private String empEmail;
    private String empPassword;
    private String empName; // Name of the employee
    private String empImage;
    private String currentAccount;
    private String supervisorName; // Supervisor's name in account
    private String empRole;
    private String empDesc;
    private String amdocsExperience; // Amdocs Experience (years or months)
    private String totalExperience; // Total Experience (years or months)
    private AmdocsJourney amdocsJourney; // Amdocs Journey (e.g., roles, growth)
    private List<String> functionalKnowledge; // Functional knowledge or domain expertise
    private List<String> primaryTechSkill; // Primary tech skill (e.g., Java, AWS)
    private List<String> primaryProductSubdomain; // Primary product or subdomain
    private List<String> secondaryTechSkill; // Secondary tech skill (e.g., Python, SQL)
    private List<String> secondaryProduct; // Secondary product knowledge
    private String devOpsKnowledge; // DevOps knowledge (tools, CI/CD, etc.)
    private boolean mentoringAbility; // Can lead/direct 5-6 people
    private boolean explorationInterest; // Likes exploring new tools/tech
    private boolean contributedToDesign; // Contributed to Design/LLD/HLD
    private boolean engagementActivityContribution; // Can help in Engagement activities
    private String areaOfCriticalIssue;
    private String productionSupport;
    private int presentationSkills; // Presentation skills (on a scale of 1-5)
    private String hobbiesSports; // Hobbies or sports
    private String additionalInfo; // Anything else you want to mention

    public Employee() {
    }

    public Employee(String empEmail, String empPassword, String empId, String empName, String empImage, String currentAccount, String supervisorName, String empRole, String empDesc, String amdocsExperience, String totalExperience, AmdocsJourney amdocsJourney, List<String> functionalKnowledge, List<String> primaryTechSkill, List<String> primaryProductSubdomain, List<String> secondaryTechSkill, List<String> secondaryProduct, String devOpsKnowledge, boolean mentoringAbility, boolean explorationInterest, boolean contributedToDesign, boolean engagementActivityContribution, String areaOfCriticalIssue, String productionSupport, int presentationSkills, String hobbiesSports, String additionalInfo, boolean approved) {
        this.empEmail = empEmail;
        this.empPassword = empPassword;
        this.empId = empId;
        this.empName = empName;
        this.empImage = empImage;
        this.currentAccount = currentAccount;
        this.supervisorName = supervisorName;
        this.empRole = empRole;
        this.empDesc = empDesc;
        this.amdocsExperience = amdocsExperience;
        this.totalExperience = totalExperience;
        this.amdocsJourney = amdocsJourney;
        this.functionalKnowledge = functionalKnowledge;
        this.primaryTechSkill = primaryTechSkill;
        this.primaryProductSubdomain = primaryProductSubdomain;
        this.secondaryTechSkill = secondaryTechSkill;
        this.secondaryProduct = secondaryProduct;
        this.devOpsKnowledge = devOpsKnowledge;
        this.mentoringAbility = mentoringAbility;
        this.explorationInterest = explorationInterest;
        this.contributedToDesign = contributedToDesign;
        this.engagementActivityContribution = engagementActivityContribution;
        this.areaOfCriticalIssue = areaOfCriticalIssue;
        this.productionSupport = productionSupport;
        this.presentationSkills = presentationSkills;
        this.hobbiesSports = hobbiesSports;
        this.additionalInfo = additionalInfo;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public String getEmpDesc() {
        return empDesc;
    }

    public void setEmpDesc(String empDesc) {
        this.empDesc = empDesc;
    }

    public String getEmpImage() {
        return empImage;
    }

    public void setEmpImage(String empImage) {
        this.empImage = empImage;
    }

    public String getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(String currentAccount) {
        this.currentAccount = currentAccount;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String name) {
        this.empName = name;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getAmdocsExperience() {
        return amdocsExperience;
    }

    public void setAmdocsExperience(String amdocsExperience) {
        this.amdocsExperience = amdocsExperience;
    }

    public String getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(String totalExperience) {
        this.totalExperience = totalExperience;
    }

    public AmdocsJourney getAmdocsJourney() {
        return amdocsJourney;
    }

    public void setAmdocsJourney(AmdocsJourney amdocsJourney) {
        this.amdocsJourney = amdocsJourney;
    }

    public List<String> getFunctionalKnowledge() {
        return functionalKnowledge;
    }

    public void setFunctionalKnowledge(List<String> functionalKnowledge) {
        this.functionalKnowledge = functionalKnowledge;
    }

    public List<String> getPrimaryTechSkill() {
        return primaryTechSkill;
    }

    public void setPrimaryTechSkill(List<String> primaryTechSkill) {
        this.primaryTechSkill = primaryTechSkill;
    }

    public List<String> getPrimaryProductSubdomain() {
        return primaryProductSubdomain;
    }

    public void setPrimaryProductSubdomain(List<String> primaryProductSubdomain) {
        this.primaryProductSubdomain = primaryProductSubdomain;
    }

    public List<String> getSecondaryTechSkill() {
        return secondaryTechSkill;
    }

    public void setSecondaryTechSkill(List<String> secondaryTechSkill) {
        this.secondaryTechSkill = secondaryTechSkill;
    }

    public List<String> getSecondaryProduct() {
        return secondaryProduct;
    }

    public void setSecondaryProduct(List<String> secondaryProduct) {
        this.secondaryProduct = secondaryProduct;
    }

    public String getDevOpsKnowledge() {
        return devOpsKnowledge;
    }

    public void setDevOpsKnowledge(String devOpsKnowledge) {
        this.devOpsKnowledge = devOpsKnowledge;
    }

    public boolean isMentoringAbility() {
        return mentoringAbility;
    }

    public void setMentoringAbility(boolean mentoringAbility) {
        this.mentoringAbility = mentoringAbility;
    }

    public boolean isExplorationInterest() {
        return explorationInterest;
    }

    public void setExplorationInterest(boolean explorationInterest) {
        this.explorationInterest = explorationInterest;
    }

    public boolean isContributedToDesign() {
        return contributedToDesign;
    }

    public void setContributedToDesign(boolean contributedToDesign) {
        this.contributedToDesign = contributedToDesign;
    }

    public boolean isEngagementActivityContribution() {
        return engagementActivityContribution;
    }

    public void setEngagementActivityContribution(boolean engagementActivityContribution) {
        this.engagementActivityContribution = engagementActivityContribution;
    }

    public int getPresentationSkills() {
        return presentationSkills;
    }

    public void setPresentationSkills(int presentationSkills) {
        this.presentationSkills = presentationSkills;
    }

    public String getHobbiesSports() {
        return hobbiesSports;
    }

    public void setHobbiesSports(String hobbiesSports) {
        this.hobbiesSports = hobbiesSports;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAreaOfCriticalIssue() {
        return areaOfCriticalIssue;
    }

    public void setAreaOfCriticalIssue(String areaOfCriticalIssue) {
        this.areaOfCriticalIssue = areaOfCriticalIssue;
    }


    public String getProductionSupport() {
        return productionSupport;
    }

    public void setProductionSupport(String productionSupport) {
        this.productionSupport = productionSupport;
    }
}
