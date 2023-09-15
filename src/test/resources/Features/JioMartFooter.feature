Feature: verify All Categories Text and Links present in JioMart Footer Page 

Scenario: verify All Categories Text and Links present in JioMart Footer Page 

	Given user should be on the Application Url "https://www.jiomart.com/" 
	When get all the Text present in All Categories Section 
	And get all the Links present in All Categories Section 
	Then Validate the Text and Links present as Expected in UI 