package com.example.jetpackcomposemarvel.common

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {
    const val PARAM_CHARACTER_ID = "characterId"
    const val PUBLIC_KEY ="88610b36a82bc53a40988328c48a83b1"
    const val PRIVATE_KEY="6d53142dfc33bfbecf14501283dc05090d27fb89"

    const val baseUrl ="https://gateway.marvel.com"
    fun getMD5(): String {
        val ts = getTimeStamp()
        val concatenatedString = ts+PRIVATE_KEY+PUBLIC_KEY
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(concatenatedString.toByteArray())).
        toString(16).padStart(32, '0')
    }
    fun getTimeStamp():String{
        val ts = Timestamp(System.currentTimeMillis())
        return  ts.time.toString()
    }

}