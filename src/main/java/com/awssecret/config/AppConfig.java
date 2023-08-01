package com.awssecret.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;



@Configuration
public class AppConfig {
	private Gson gson=new Gson();
	
	@Bean
	DataSource dataSource() {
		AwsSecrets awsSecrets=getSecret();
		try {
		System.out.println("jdbc:"+awsSecrets.getEngine()+"://"+awsSecrets.getHost()+":"+awsSecrets.getPort()+"/testDb");
		System.out.println("userName :"+ awsSecrets.getUsername());
		System.out.println("password :"+ awsSecrets.getPassword());
		return DataSourceBuilder.create()
								.url("jdbc:"+awsSecrets.getEngine()+"://"+awsSecrets.getHost()+":"+awsSecrets.getPort()+"/testDb")
								.username(awsSecrets.getUsername())
								.password(awsSecrets.getPassword())
								.build();
		}
		catch (Exception e) {
			System.out.println("ERROR MESSAGE :"+ e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public  AwsSecrets getSecret() {

	    String secretName = "db-credential";
	    Region region = Region.of("ap-south-1");

	    SecretsManagerClient client = SecretsManagerClient.builder()
	            .region(region)
	            .credentialsProvider(()->{
	            	return new AwsCredentials() {
						
						@Override
						public String secretAccessKey() {
							
							return "d+KSGPXG9IPwXsEA/WnQxhpVOJQSeI+UMobgU6st";
						}
						
						@Override
						public String accessKeyId() {
							return "AKIASL76ADM5FKK7FYOK";
						}
					};
	            })
	            .build();

	    GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
	            .secretId(secretName)
	            .build();

	    GetSecretValueResponse getSecretValueResponse; 

	    try {
	        getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
	    } catch (Exception e) {
	        // For a list of exceptions thrown, see
	        // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
	        throw e;
	    }

	    String secret = getSecretValueResponse.secretString();
		return gson.fromJson(secret, AwsSecrets.class);

	}
}
