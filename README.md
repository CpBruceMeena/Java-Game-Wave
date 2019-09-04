# Java-Game-Wave

/**
This is not originally made by me, it's just for the purpose of learning java, and how to work with GUI and create games.
*/

This repository contains the files required for creating the game Wave. It's basically a fun project. We are using java language for the coding purpose. 

I'll give the description of the source files in the alphabetical order.

1. Basic Enemy = This source file contain the code for creating an outline of enemy, how it'll move and affect the player.

2. Trail = This contains the code for creating how the enemy looks like, basically we're trying to make the game in the form of trail, means the enemy and the player move in the form of trail.

3. Spawn = Here we are focussing on the the difficulty level of the game, and how the game proceeds when the difficuly increases and the levels increases.

4. Window = It contains the code to create the window file, in which the game will run.

5. Game Object = All the enemys, player are bascially the game objects that we're going to add in the game. The code written here helps us to get the details about the game objects i.e., player and enemies, basically their location, speed and other.

6. FastEnemy = The majority of the code is same as BasicEnemy, the only thing that is changing is the movement of the enemy, now the enemy moves faster, so it becomes quite difficult to keep the player safe from the enemies.

7. SmartEnemy = This enemy is slow, but what special here is, the enemy always moves towards the player with a comparative slow speed, so that is the player is trying to hide in some corner and not moving, so this enemy will move towards the player, so basically it forces the player to keep on moving to maintain its health.

8. EnemyBoss = This one is last kind of enemy in our game, It's sort of a big box type enemy, and it shoots bullets enemies.

9. EnemyBossBullet = This one is used for the enemyboss, these are the bullets that the enemy boss is going to fire on the player.

10. Menu = It contains the first page of our game. It is the menu that contains the buttons for game, help and quit.

11. MenuParticle = Here we are writing code to show waves on the page of menu, so the game looks interesting. 

12. HardEnemy = This contains the code for enemy when we play the game in the difficulty mode, in general here it's quite difficult to predict the movement of the enemy

13. Game = This is the main file, which connects all the other files, and we can run the game from here.

14. Handler = Here we are creating a linked list to contain all the game objects, and to handle all the objects that are in our game, we can add objects and remove objects using this file.

15. HUD = This is the display file. It contains the code which helps us to see the score and the level that is actually present on the game screen. 

16. ID = This contains the id of the game objects that we are going to use in our game, i.e., we are using enumeration for this purpose, we have player, basicenemy, hardenemy, fastenemy, smartenemy as our ids.
 
I'm providing a summary below to understand, how the game is actually created, and how you should proceed.
First of all we need to create the main file, that is the Game file, then we need to create the window file, which allows us to run the game in the window. After that we move on to the handler and gameobjects file, using which we can create the enemies and the player. 
(Note: The handler, player, menu, and some other files needs to continuously updated, as all the files are linked to each other.) 
Now, moving on to the next things, we create the player and the basic enemy, here basic enemy works as a outline for all the types of enmies that we are trying to create. In the same file, we code the description of player and enemy, how they look like, how they move and their restictions on the screen, i.e., they cannot go out of the window frame. Now using the code for basic enemy, we can create all the other types of enemies that we need in our game, so the difficulty can be raised as the level and score increases. We are creating the trail file, because we want our game to look like wave, means when the player and the enemies move they should leave a trail. Now we move on to the HUD file, which helps us to keep the track of the score and level, which will be used to add the number of enemies in the game. As we have created the HUD file, which helps us to keep the track of the score and the level, now we need to create the spawn file, which will be used to update the game when the difficulty increases and the level increases. 
Now all the required files are created, then we need to create the menu file, which will contain the options like game, help and quit, Next, we need to define the mouse settings to change the screen when someone clicks on the button. In general, we are trying to create the states of the game, i.e., the end state, pause state, help, and the game state. In the game state, we have created two types, one is Normal and the other one is Hard, they basically differ in the type of enemies they contain. After that we need to set our game state, as what will happen when our player health will reach to zero, means our game should terminate.
We need to keep updating the changes in all the required files, as all are linked. 


