package io.swagger.client.api

import io.swagger.client.model.Correlation
import io.swagger.client.model.PostCorrelation
import io.swagger.client.model.JsonErrorResponse
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class CorrelationsApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get correlations
   * Get correlations
   * @param effect ORIGINAL variable name of the effect variable for which the user desires correlations
   * @param cause ORIGINAL variable name of the cause variable for which the user desires correlations
   * @return List[Correlation]
   */
  def correlationsGet (effect: String, cause: String) : Option[List[Correlation]] = {
    // create path and map variables
    val path = "/correlations".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(effect) != "null") queryParams += "effect" -> effect.toString
    if(String.valueOf(cause) != "null") queryParams += "cause" -> cause.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Correlation]).asInstanceOf[List[Correlation]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get average correlations for variables containing search term
   * Returns the average correlations from all users for all public variables that contain the characters in the search query. Returns average of all users public variable correlations with a specified cause or effect.
   * @param search Name of the variable that you want to know the causes or effects of.
   * @param effectOrCause Specifies whether to return the effects or causes of the searched variable.
   * @return List[Correlation]
   */
  def publicCorrelationsSearchSearchGet (search: String, effectOrCause: String) : Option[List[Correlation]] = {
    // create path and map variables
    val path = "/public/correlations/search/{search}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "search" + "\\}",apiInvoker.escape(search))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(effectOrCause) != "null") queryParams += "effectOrCause" -> effectOrCause.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Correlation]).asInstanceOf[List[Correlation]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Add correlation or/and vote for it
   * Add correlation or/and vote for it
   * @param body Provides correlation data
   * @return void
   */
  def v1CorrelationsPost (body: PostCorrelation)  = {
    // create path and map variables
    val path = "/v1/correlations".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = body

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Search user correlations for a given effect
   * Returns average of all correlations and votes for all user cause variables for a given effect. If parameter \&quot;include_public\&quot; is used, it also returns public correlations. User correlation overwrites or supersedes public correlation.
   * @param organizationId Organization ID
   * @param userId User id
   * @param variableName Effect variable name
   * @param organizationToken Organization access token
   * @param includePublic Include bublic correlations, Can be \&quot;1\&quot; or empty.
   * @return List[Correlation]
   */
  def v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameCausesGet (organizationId: Integer, userId: Integer, variableName: String, organizationToken: String, includePublic: String) : Option[List[Correlation]] = {
    // create path and map variables
    val path = "/v1/organizations/{organizationId}/users/{userId}/variables/{variableName}/causes".replaceAll("\\{format\\}","json").replaceAll("\\{" + "organizationId" + "\\}",apiInvoker.escape(organizationId))

    .replaceAll("\\{" + "userId" + "\\}",apiInvoker.escape(userId))

    .replaceAll("\\{" + "variableName" + "\\}",apiInvoker.escape(variableName))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(organizationToken) != "null") queryParams += "organization_token" -> organizationToken.toString
    if(String.valueOf(includePublic) != "null") queryParams += "include_public" -> includePublic.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Correlation]).asInstanceOf[List[Correlation]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Search user correlations for a given cause
   * Returns average of all correlations and votes for all user cause variables for a given effect. If parameter \&quot;include_public\&quot; is used, it also returns public correlations. User correlation overwrites or supersedes public correlation.
   * @param organizationId Organization ID
   * @param userId User id
   * @param variableName Cause variable name
   * @param organizationToken Organization access token
   * @param includePublic Include bublic correlations, Can be \&quot;1\&quot; or empty.
   * @return List[Correlation]
   */
  def v1OrganizationsOrganizationIdUsersUserIdVariablesVariableNameEffectsGet (organizationId: Integer, userId: Integer, variableName: String, organizationToken: String, includePublic: String) : Option[List[Correlation]] = {
    // create path and map variables
    val path = "/v1/organizations/{organizationId}/users/{userId}/variables/{variableName}/effects".replaceAll("\\{format\\}","json").replaceAll("\\{" + "organizationId" + "\\}",apiInvoker.escape(organizationId))

    .replaceAll("\\{" + "userId" + "\\}",apiInvoker.escape(userId))

    .replaceAll("\\{" + "variableName" + "\\}",apiInvoker.escape(variableName))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(organizationToken) != "null") queryParams += "organization_token" -> organizationToken.toString
    if(String.valueOf(includePublic) != "null") queryParams += "include_public" -> includePublic.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Correlation]).asInstanceOf[List[Correlation]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Search user correlations for a given effect
   * Returns average of all correlations and votes for all user cause variables for a given effect
   * @param variableName Effect variable name
   * @return List[Correlation]
   */
  def v1VariablesVariableNameCausesGet (variableName: String) : Option[List[Correlation]] = {
    // create path and map variables
    val path = "/v1/variables/{variableName}/causes".replaceAll("\\{format\\}","json").replaceAll("\\{" + "variableName" + "\\}",apiInvoker.escape(variableName))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Correlation]).asInstanceOf[List[Correlation]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Search user correlations for a given cause
   * Returns average of all correlations and votes for all user effect variables for a given cause
   * @param variableName Cause variable name
   * @return List[Correlation]
   */
  def v1VariablesVariableNameEffectsGet (variableName: String) : Option[List[Correlation]] = {
    // create path and map variables
    val path = "/v1/variables/{variableName}/effects".replaceAll("\\{format\\}","json").replaceAll("\\{" + "variableName" + "\\}",apiInvoker.escape(variableName))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Correlation]).asInstanceOf[List[Correlation]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Search public correlations for a given effect
   * Returns average of all correlations and votes for all public cause variables for a given effect
   * @param variableName Effect variable name
   * @return List[Correlation]
   */
  def v1VariablesVariableNamePublicCausesGet (variableName: String) : Option[List[Correlation]] = {
    // create path and map variables
    val path = "/v1/variables/{variableName}/public/causes".replaceAll("\\{format\\}","json").replaceAll("\\{" + "variableName" + "\\}",apiInvoker.escape(variableName))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Correlation]).asInstanceOf[List[Correlation]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Search public correlations for a given cause
   * Returns average of all correlations and votes for all public cause variables for a given cause
   * @param variableName Cause variable name
   * @return List[Correlation]
   */
  def v1VariablesVariableNamePublicEffectsGet (variableName: String) : Option[List[Correlation]] = {
    // create path and map variables
    val path = "/v1/variables/{variableName}/public/effects".replaceAll("\\{format\\}","json").replaceAll("\\{" + "variableName" + "\\}",apiInvoker.escape(variableName))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Correlation]).asInstanceOf[List[Correlation]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
