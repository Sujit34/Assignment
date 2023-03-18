package properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;
@ConfigurationProperties(prefix = "app")
@Validated
public class ApplicationProperties {

    @NotBlank
    private String applicationName;
    @NotBlank
    private String version;
    @NotBlank
    private String serverUrl;

    private String serverName;

    private String firstName;

    private String lastName;
    @NotBlank
    @Size(max = 15, min = 8)
    private String userName;
    @NotBlank
    @Size(max = 15, min = 8)
    private String password;

    private List<String> countries;
    public ApplicationProperties(){}

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public void printProperties() {
        System.out.println("applicationName="+getApplicationName());
        System.out.println("version="+getVersion());
        System.out.println("serverUrl="+getServerUrl());
        System.out.println("serverName="+getServerName());
        System.out.println("user firstname="+getFirstName());
        System.out.println("user lastname="+getLastName());
        System.out.println("user username="+getUserName());
        System.out.println("user password="+getPassword());

        for(String s:  countries) {
            System.out.println(s);
        }
    }
}
