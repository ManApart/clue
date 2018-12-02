# Clue

Experiment with creating AI for the Clue board game.

Game currently runs to completion with just process of elimination. In the future I'd like to use 'memory' and correlation to reduce the number of necessary turns to find a solution.

Optimization:
* Remember who showed me what card
* Remember who couldn't answer an accusation, and who could
* Cross correlate to count cards
* Use informed decisions to make better guesses


Process of elimination output:
```
Connected to the target VM, address: '127.0.0.1:62522', transport: 'socket'
Starting game; looking for answer: Accusation(person=GREEN, weapon=WRENCH, room=HALL)
GREEN makes Accusation(person=MUSTARD, weapon=KNIFE, room=BILLIARD_ROOM)
MUSTARD can deny the accusation
MUSTARD makes Accusation(person=PEACOCK, weapon=ROPE, room=CONSERVATORY)
PEACOCK can deny the accusation
PEACOCK makes Accusation(person=SCARLETT, weapon=PIPE, room=DINING_ROOM)
GREEN cannot deny the accusation
MUSTARD can deny the accusation
GREEN makes Accusation(person=PLUM, weapon=PIPE, room=DINING_ROOM)
MUSTARD can deny the accusation
MUSTARD makes Accusation(person=WHITE, weapon=WRENCH, room=BALLROOM)
PEACOCK can deny the accusation
PEACOCK makes Accusation(person=GREEN, weapon=ROPE, room=HALL)
GREEN can deny the accusation
GREEN makes Accusation(person=WHITE, weapon=CANDLESTICK, room=BILLIARD_ROOM)
MUSTARD can deny the accusation
MUSTARD makes Accusation(person=PLUM, weapon=WRENCH, room=HALL)
PEACOCK can deny the accusation
PEACOCK makes Accusation(person=MUSTARD, weapon=PIPE, room=DINING_ROOM)
GREEN cannot deny the accusation
MUSTARD can deny the accusation
GREEN makes Accusation(person=GREEN, weapon=WRENCH, room=KITCHEN)
MUSTARD cannot deny the accusation
PEACOCK can deny the accusation
MUSTARD makes Accusation(person=GREEN, weapon=WRENCH, room=LOUNGE)
PEACOCK cannot deny the accusation
GREEN can deny the accusation
PEACOCK makes Accusation(person=GREEN, weapon=WRENCH, room=LOUNGE)
GREEN can deny the accusation
GREEN makes Accusation(person=SCARLETT, weapon=KNIFE, room=DINING_ROOM)
MUSTARD can deny the accusation
MUSTARD makes Accusation(person=GREEN, weapon=WRENCH, room=KITCHEN)
PEACOCK can deny the accusation
PEACOCK makes Accusation(person=GREEN, weapon=PIPE, room=BALLROOM)
GREEN can deny the accusation
GREEN makes Accusation(person=WHITE, weapon=KNIFE, room=DINING_ROOM)
MUSTARD can deny the accusation
MUSTARD makes Accusation(person=GREEN, weapon=ROPE, room=BILLIARD_ROOM)
PEACOCK can deny the accusation
PEACOCK makes Accusation(person=PEACOCK, weapon=CANDLESTICK, room=HALL)
GREEN can deny the accusation
GREEN makes Accusation(person=WHITE, weapon=WRENCH, room=DINING_ROOM)
MUSTARD can deny the accusation
MUSTARD makes Accusation(person=GREEN, weapon=ROPE, room=BALLROOM)
PEACOCK cannot deny the accusation
GREEN can deny the accusation
PEACOCK makes Accusation(person=GREEN, weapon=PIPE, room=HALL)
GREEN cannot deny the accusation
MUSTARD can deny the accusation
GREEN makes Accusation(person=GREEN, weapon=WRENCH, room=CONSERVATORY)
MUSTARD cannot deny the accusation
PEACOCK can deny the accusation
MUSTARD makes Accusation(person=PEACOCK, weapon=WRENCH, room=BALLROOM)
PEACOCK cannot deny the accusation
GREEN can deny the accusation
PEACOCK makes Accusation(person=GREEN, weapon=CANDLESTICK, room=HALL)
GREEN cannot deny the accusation
MUSTARD can deny the accusation
GREEN makes Accusation(person=WHITE, weapon=WRENCH, room=BILLIARD_ROOM)
MUSTARD cannot deny the accusation
PEACOCK can deny the accusation
MUSTARD makes Accusation(person=GREEN, weapon=WRENCH, room=STUDY)
PEACOCK cannot deny the accusation
GREEN can deny the accusation
PEACOCK makes Accusation(person=GREEN, weapon=REVOLVER, room=DINING_ROOM)
GREEN can deny the accusation
GREEN makes Accusation(person=GREEN, weapon=WRENCH, room=HALL)
MUSTARD, PEACOCK cannot deny the accusation
Discovered GREEN
Discovered WRENCH
Discovered HALL
MUSTARD makes Accusation(person=GREEN, weapon=REVOLVER, room=BALLROOM)
PEACOCK cannot deny the accusation
GREEN can deny the accusation
PEACOCK makes Accusation(person=GREEN, weapon=KNIFE, room=HALL)
GREEN cannot deny the accusation
MUSTARD can deny the accusation
GREEN has solved the murder.
Answer: Accusation(person=GREEN, weapon=WRENCH, room=HALL)Disconnected from the target VM, address: '127.0.0.1:62522', transport: 'socket'

Process finished with exit code 0
```