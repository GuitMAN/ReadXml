package ru.example

import java.io.FileInputStream
import java.io.IOException
import javax.xml.stream.XMLInputFactory
import javax.xml.stream.XMLStreamConstants
import javax.xml.stream.XMLStreamException


class ReadXml {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello world!")

            var fis: FileInputStream? = null
            try {
                fis = FileInputStream("D:\\Repos\\ReadXML\\src\\main\\resources\\20220819_ED807_full.xml")
                val reader = XMLInputFactory.newInstance().createXMLStreamReader(fis)
                var i = 0
                while (reader.eventType != XMLStreamConstants.END_DOCUMENT) {
                    reader.next()
                    if (reader.isEndElement) continue
                    if (reader.eventType == XMLStreamConstants.END_DOCUMENT)
                    break

                    if (reader.localName=="BICDirectoryEntry"){
                        i++
                        println( i)}
                }
            } catch (exc: IOException) {
            } catch (exc: XMLStreamException) {
            }
        }
    }
}