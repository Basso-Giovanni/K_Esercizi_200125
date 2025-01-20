/*
    Esercizio 2
    Quanti diversi modi ci sono per creare un array in Kotlin?
    Scrivi un programma che elenca tutte le modalità.
 */

fun main()
{
    //tramite arrayOf()
    val array1 = arrayOf("Verde", "Bianco", "Rosso")

    //tramite arrayOfNulls che crea un array di null
    val array2: Array<String?> = arrayOfNulls(3)

    //tramite emptyArray()
    val array3 = emptyArray<String>()

    //tramite oggetto Array
    val array4 = Array(3) {"Verde"; "Bianco"; "Rosso"}
}