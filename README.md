# MoneyApp

Create a mini version of the Moneybox app that will allow existing users to login, check their account and add money to their moneybox.


# Part A - Fix current bugs

## Bug 1 - Layout does not look as expected

Please re-arrange the views in the LoginActivity to match the expected layout.

Bug: Layout was not in centre and email field not properly set because of that password and name fields are also not set properly.

Solve: By using Constraint-layout and set all the necessary properties to each fields and set layout as expected.

## Bug 2 - Validation is incorrect
  
There is some validation logic in LoginActivity, but it is currently incorrect. Please implement this feature to match this logic.

Solve: As Email and Password fields are compulsory change necessary change for name; if name field is empty still user can login if there is value in name field match with name_regex and allow user to login.

## Bug 3 - Animation is looping incorrectly

Above the login button is an animation of an owl and a pig. We would like this animation to play every time the user starts the activity and then loop indefinitely. The logic for this animation should be as follows:
	
  •	The animation should start from frame 0 to 109 when the user first starts the activity. See below for animation. ￼
	
  •	When the first stage of the animation has finished it should then loop from frame 131 to 158 continuously.


Bug: Animation was not continues.

Solve: Implement AnimatorListener and use implemented method change necessary like repeatCount and setMinandMaxFrame


# Part B - Add 2 new screens

To allow them to log into the app, view and edit their account using our sandbox API And necessary creadiantials.

Screen 2 - User accounts screen

This screen should be shown after the user has successfully logged in and should show have the following functionality:
	
  •	Display "Hello {name} only if they provided it on previous screen"
	
  •	Show the 'TotalPlanValue' of a user.
	
  •	Show the accounts the user holds, e.g. ISA, GIA, LISA, Pension.
	
  •	Show all of those account's 'PlanValue'.
	
  •	Show all of those account's 'Moneybox' total.

Screen 3 - Individual account screen

If a user selects one of those accounts, they should then be taken to this screen. This screen should have the following functionality:
	
  •	Show the 'Name' of the account.
	
  •	Show the account's 'PlanValue'.
	
  •	Show the accounts 'Moneybox' total.
	
  •	Allow a user to add to a fixed value (e.g. £10) to their moneybox total.


# Languages, libraries and tools used:
		 
		Kotlin
		MVVM Architecture
		Data Binding
		Retrofit
		GsonParsing
		Lottie 
		



		

