Feature: Test the Slider Pagination feature in JoiMart 

Scenario: Test the Slider Pagination in JoiMart Application

Given user should be on the Application Url "https://www.jiomart.com/"
When click all the Slider pages visible on WebPage
Then Check the prevoius Arrow button is displayed and is Clickable
And  Check the Next Arrow button is displayed and is Clickable