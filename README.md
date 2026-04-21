# Display Bookshelves – Automation Testing Hackathon
 
## Overview
This project automates user scenarios on an e-commerce furniture website (Suggested site: https://www.urbanladder.com).
The automation covers product filtering, menu extraction, form validation, and essential Selenium concepts.
 

 
## Problem Statement
 
Automate and display the following:
 
### Bookshelves
- Display the **name and price** of bookshelves **below Rs. 15000**
- **Include out-of-stock** items where specified
- **Storage type** must be **Open**
- If more than one item has the **same price**, include all such items
 
### Study Chairs
- Display the **first 3 study chairs** with the **highest recommendation**
 
---
 
## Hackathon Tasks
 
### Task 1: Bookshelves Filtering
- Navigate to the Bookshelves section
- Apply filters:
  - Price: Below Rs. 15000
  - Storage Type: Open
  - Exclude out-of-stock items
- Display the **name and price** of the **first 3 bookshelves**
- If multiple items have the same price, include all
 
---
 
### Task 2: Collections Menu Extraction
- Navigate to **Collections**
- Select **Being At Home**
- Retrieve **all sub-menu items**
- Store them in a **List / Collection**
- Display the stored items
 
---
 
### Task 3: Gift Card Validation
- Navigate to **Gift Cards**
- Select **Birthday / Anniversary**
- Customize the gift card
- Fill **From** and **To** details
- Enter **one invalid input** (example: invalid email)
- Capture and display the **error message**
 
---
 
## Key Automation Scope
 
- Handling alerts and warning messages
- Searching and filtering products
- Extracting menu items into collections
- Navigating between pages
- Scrolling through the web page
- Filling forms with multiple web elements
- Capturing validation error messages
 
---
 
## Tools & Technologies
 
- Programming Language: Java / Python
- Automation Tool: Selenium WebDriver
- Testing Framework: TestNG / PyTest
- Build Tool: Maven / Gradle
- Browser: Chrome / Edge
 
---
 
## Expected Output
 
- Bookshelf names and prices in console
- Study chairs with highest recommendations
- List of sub-menu items under Being At Home
- Gift card validation error message
 
---
 
## Notes
 
- Website content may change; scripts should handle dynamic data
- Use explicit waits for synchronization
- Avoid hard-coded values
 
---
 
## Author
Automation Hackathon Project by charantejakedyam
 
