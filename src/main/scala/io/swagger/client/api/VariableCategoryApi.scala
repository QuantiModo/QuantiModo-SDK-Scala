package io.swagger.client.api

import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200_23
import io.swagger.client.model.VariableCategory
import io.swagger.client.model.Inline_response_200_24
import io.swagger.client.model.Inline_response_200_2
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class VariableCategoryApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all VariableCategories
   * Get all VariableCategories
   * @param name name
   * @param fillingValue filling_value
   * @param maximumAllowedValue maximum_allowed_value
   * @param minimumAllowedValue minimum_allowed_value
   * @param durationOfAction duration_of_action
   * @param onsetDelay onset_delay
   * @param combinationOperation combination_operation
   * @param updated updated
   * @param causeOnly cause_only
   * @param public public
   * @param outcome outcome
   * @param createdAt created_at
   * @param updatedAt updated_at
   * @param imageUrl image_url
   * @param defaultUnitId default_unit_id
   * @param limit limit
   * @param offset offset
   * @param sort sort
   * @return Inline_response_200_23
   */
  def variableCategoriesGet (name: String, fillingValue: Number, maximumAllowedValue: Number, minimumAllowedValue: Number, durationOfAction: Integer, onsetDelay: Integer, combinationOperation: String, updated: Integer, causeOnly: Boolean, public: Integer, outcome: Boolean, createdAt: String, updatedAt: String, imageUrl: String, defaultUnitId: Integer, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_23] = {
    // create path and map variables
    val path = "/variableCategories".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(name) != "null") queryParams += "name" -> name.toString
    if(String.valueOf(fillingValue) != "null") queryParams += "filling_value" -> fillingValue.toString
    if(String.valueOf(maximumAllowedValue) != "null") queryParams += "maximum_allowed_value" -> maximumAllowedValue.toString
    if(String.valueOf(minimumAllowedValue) != "null") queryParams += "minimum_allowed_value" -> minimumAllowedValue.toString
    if(String.valueOf(durationOfAction) != "null") queryParams += "duration_of_action" -> durationOfAction.toString
    if(String.valueOf(onsetDelay) != "null") queryParams += "onset_delay" -> onsetDelay.toString
    if(String.valueOf(combinationOperation) != "null") queryParams += "combination_operation" -> combinationOperation.toString
    if(String.valueOf(updated) != "null") queryParams += "updated" -> updated.toString
    if(String.valueOf(causeOnly) != "null") queryParams += "cause_only" -> causeOnly.toString
    if(String.valueOf(public) != "null") queryParams += "public" -> public.toString
    if(String.valueOf(outcome) != "null") queryParams += "outcome" -> outcome.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
    if(String.valueOf(imageUrl) != "null") queryParams += "image_url" -> imageUrl.toString
    if(String.valueOf(defaultUnitId) != "null") queryParams += "default_unit_id" -> defaultUnitId.toString
    if(String.valueOf(limit) != "null") queryParams += "limit" -> limit.toString
    if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
    if(String.valueOf(sort) != "null") queryParams += "sort" -> sort.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_23]).asInstanceOf[Inline_response_200_23])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store VariableCategory
   * Store VariableCategory
   * @param body VariableCategory that should be stored
   * @return Inline_response_200_24
   */
  def variableCategoriesPost (body: VariableCategory) : Option[Inline_response_200_24] = {
    // create path and map variables
    val path = "/variableCategories".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_24]).asInstanceOf[Inline_response_200_24])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get VariableCategory
   * Get VariableCategory
   * @param id id of VariableCategory
   * @return Inline_response_200_24
   */
  def variableCategoriesIdGet (id: Integer) : Option[Inline_response_200_24] = {
    // create path and map variables
    val path = "/variableCategories/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_24]).asInstanceOf[Inline_response_200_24])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update VariableCategory
   * Update VariableCategory
   * @param id id of VariableCategory
   * @param body VariableCategory that should be updated
   * @return Inline_response_200_2
   */
  def variableCategoriesIdPut (id: Integer, body: VariableCategory) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/variableCategories/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
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
      apiInvoker.invokeApi(basePath, path, "PUT", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_2]).asInstanceOf[Inline_response_200_2])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Delete VariableCategory
   * Delete VariableCategory
   * @param id id of VariableCategory
   * @return Inline_response_200_2
   */
  def variableCategoriesIdDelete (id: Integer) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/variableCategories/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
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
      apiInvoker.invokeApi(basePath, path, "DELETE", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_2]).asInstanceOf[Inline_response_200_2])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
