import java.util.*
//import kotlinx.serialization.*
//import kotlinx.serialization.json.JSON


fun main(args: Array<String>) {
//    val jsonObject = JSONToken(response).nextValue() as JSONObject

    // For now, we have a hardcoded list of words for our program. This is where we randomly choose a word from the list
    val wordList = arrayOf("elephant", "horse", "computer", "program", "guitar", "bass", "piano", "dice", "dragon", "elves", "sunset");
    val randomNumber = Random().nextInt(0, wordList.size-1)
    val word = wordList[randomNumber];

    // Start playing our game
    wordle(word);
}

/*
*
* */
fun wordle(word: String) {
    val length = word.length;
    println("Rules of the game: ");
    println("* is an incorrect letter");
    println("Capital letter is correct letter in the correct spot e.g. (A)");
    println("Uncapitalized letter is correct letter in the incorrect spot e.g. (a)")
    println();
    println("Word:");
    for(i in 0 until length) {
        print("* ")
    }
    println("\n");
    var gameOver = false;

    while(!gameOver) {
        println("Your guess: ")
        val userGuess = readLine();
        gameOver = guess(word, userGuess.toString());
    }
}

fun guess(word:String, guess:String): Boolean {
    var hint = "";
    // If the words are the same, gameOver becomes true
    if(word.lowercase() == guess.lowercase()) {
        println("You guessed correctly! You win!")
        return true;
    }

    // If the words are not the same, check what letters are in the word
    else {
        for (i in guess.indices) {
            for (j in word.indices) {
                try {
                    if (word.contains(guess[i].toChar().lowercaseChar())) {
                        if (i == word.indexOf(guess[i].toChar().lowercaseChar())) {
                            hint += guess[i].toChar().uppercaseChar() + " ";
                            break;
                        } else {
                            hint += guess[i].toChar().lowercaseChar() + " ";
                            break;
                        }
                    } else {
                        hint += "* ";
                        break;
                    }
                } catch (e: StringIndexOutOfBoundsException) {
                    println("String out of bounds exception")
                }
            }
        }
    }
    println(hint);
    return false;
}