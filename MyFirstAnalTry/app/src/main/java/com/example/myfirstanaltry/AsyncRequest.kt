package com.example.myfirstanaltry

import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


    public fun Post(link : String , PostRequest: JSONObject) : String {
        val url : URL =  URL (link)
        with(url.openConnection() as HttpURLConnection){
            readTimeout=10000
            connectTimeout=10000
            requestMethod= "POST"
            setRequestProperty("Content-Type","application/json; utf-8");
            setRequestProperty("Accept","application/json");
            setRequestProperty("Accept-Charset","UTF-8");
            setRequestProperty("Accept-Language","ru-RU");
            doInput= true
            doOutput=true
            var L: ByteArray = PostRequest.toString().toByteArray(Charsets.UTF_8)
            val os = outputStream
            os.write(L,0,PostRequest.toString().length);
                 //if(this.responseCode==HttpURLConnection.HTTP_OK){
                val ins = BufferedReader(InputStreamReader(inputStream,"utf-8"))
                var sb = StringBuilder()
                var line : String? = null
                line= ins.readLine()
                while(line!=null){
                    sb.append(line.trim());
                    line= ins.readLine().toString();
                }

                return sb.toString()
        }
      // return this.responseCode.toString()

    }

