package io.swagger.client.api

import io.swagger.client.model.User
import io.swagger.client.model.UserTokenRequest
import io.swagger.client.model.UserTokenFailedResponse
import io.swagger.client.model.UserTokenSuccessfulResponse
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class UserApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  def userMeGet ()  = {
    // create path and map variables
    val path = "/user/me".replaceAll("\\{format\\}","json")

    
    val contentType = {
      
      "application/json"
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    
    
    

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
  
  def v1OrganizationsOrganizationIdUsersPost (organizationId: Integer, body: UserTokenRequest) : Option[UserTokenSuccessfulResponse] = {
    // create path and map variables
    val path = "/v1/organizations/{organizationId}/users".replaceAll("\\{format\\}","json").replaceAll("\\{" + "organizationId" + "\\}",apiInvoker.escape(organizationId))

    

    
    val contentType = {
      if(body != null && body.isInstanceOf[File] )
        "multipart/form-data"
      else "application/json"
      
      
    }

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]

    

    
    
    

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, body, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[UserTokenSuccessfulResponse]).asInstanceOf[UserTokenSuccessfulResponse])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
