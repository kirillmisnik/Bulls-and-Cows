# Bulls-and-Cows

https://hyperskill.org/projects/53

Быки и коровы — логическая игра, в ходе которой игрок должен определить сгенерированную программой последовательность символов. Игрок задает длинну кода (в пределах 36 символов) и то, сколько различных символов могут быть задействованы при его генерации. После каждой попытки программа выставляет «оценку», указывая количество угаданного без совпадения с их позициями (количество «коров») и полных совпадений (количество «быков»). Игра заканчивается, когда игрок отгадает заданную последовательность.

Пример партии:
```
Input the length of the secret code:
> 4
Input the number of possible symbols in the code:
> 12
The secret is prepared: **** (0-9, a-b).
Okay, let's start a game!
Turn 1:
> a234
Grade: 1 bull and 1 cow
Turn 2:
> 73b4
Grade: 2 bulls and 1 cow
Turn 3:
> 9374
Grage: 4 bulls
Congratulations! You guessed the secret code.
```
