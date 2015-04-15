package io.swagger.client.api

import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class OauthApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  def oauth2AuthorizeGet (response_type: String, redirect_uri: String, realm: String, client_id: String, scope: String, state: String)  = {
    // create path and map variables
    val path = "/oauth2/authorize".replaceAll("\\{format\\}","json")

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    if(String.valueOf(response_type) != "null") queryParams += "response_type" -> response_type.toString
    if(String.valueOf(redirect_uri) != "null") queryParams += "redirect_uri" -> redirect_uri.toString
    if(String.valueOf(realm) != "null") queryParams += "realm" -> realm.toString
    if(String.valueOf(client_id) != "null") queryParams += "client_id" -> client_id.toString
    if(String.valueOf(scope) != "null") queryParams += "scope" -> scope.toString
    if(String.valueOf(state) != "null") queryParams += "state" -> state.toString
    
    
    

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, None, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
