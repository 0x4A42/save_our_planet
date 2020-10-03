# Save Our Planet

This project is an import from a group university project repo. The purpose of this game was to develop a small, monopoly style game which is played in the command line, developed in an agile setting.

 ## Rules

 * Each game can have between 2 - 4 players (inclusive).

 * Players will navigate the board by rolling a pair of die - it will be possible to roll 1 - 6 (inclusive) on each die, for a max of 12. 

 * The currency used within the game is EcoCoins. Players begin with 125 EcoCoins and are awarded 75 EcoCoins each time they pass the Start square.

 * Players take turns to travel around the board. They begin on a 'Start' square. 
	- If the player lands on an area that is not owned, they will be asked if they wished to purchase it. 
	- If the player lands on an area owned by another player, they must pay an EcoCoin fee to the owner (this will scale with the amount of upgrades on the property).
	- If the player lands on the Eco-Pit Stop, nothing will happen for the rest of their turn.

 * Player names must be between 1 - 15 characters in length. Any excess length will be removed.

 * When a player is prompted to take their turn, they will have four options. 
	 - If a player selects X, you will take your turn as normal. 
	 - If a player selects U, the game will check if the player owns all areas within a field. 
		- If the player does, they will be prompted to select which property to upgrade (if they own 3 minor upgrades, they will then be able to purchase a major upgrade). 
		- If the player cannot purchase an upgrade, you will roll as normal. 
	- If a player selects U, they will be shown a list of their current properties and their respective upgrades. 
	- If a player selects Q, they will attempt to exit the game. 
		- Upon pressing Y, the game will end and the winner (which cannot be the player who triggers the end the game through the menu selection) will be determined. 
		- If the player selects N, the game will continue as normal.

 * The game ends when either a player selects Q from the menu selection or when one player runs out of money. 
