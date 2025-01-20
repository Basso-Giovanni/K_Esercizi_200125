import java.io.File

/* Esercizio 1
    Implementa un programma console che riceve in input chiave e valore, li memorizza in una HashMap e, se
    l'utente digita salva vengono memorizzati in un File di testo.
    Al nuovo avvio del programma i dati del file vengono caricati nell'hashmap.
*/

fun main()
{
    val map : HashMap<String, String> = HashMap()
    val filePath = "output.txt"
    val content = File(filePath).readText()
    val riga = content.split("\n")
    for (item in riga)
    {
        if (item != "")
        {
            val el = item.split('-')
            map.put(el[0], el[1])
        }
    }

    while (true)
    {
        println("HASHMAP: Scrivi chiave e valore da aggiungere (stringa1-stringa2). Se vuoi salvare scrivi 'salva'")

        val input = readln()

        if (input.equals("salva"))
        {
            salva(map)
            return
        }
        else
        {
            val pars = input.split("-")

            if (pars.size == 2)
            {
                map.put(pars[0], pars[1])
            }
            else
            {
                println("Hai scritto male 🫢")
            }
        }
    }
}

fun salva(map: Map<String, String>)
{
    val filePath = "output.txt"
    val file = File(filePath)
    var testo = ""
    for ((key, value) in map)
    {
        testo += key + "-" + value + "\n"
    }

    file.writeText(testo)
    println("Salvato.")
}