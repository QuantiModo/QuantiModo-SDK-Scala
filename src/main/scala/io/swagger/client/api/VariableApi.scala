package io.swagger.client.api

import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200_27
import io.swagger.client.model.Variable
import io.swagger.client.model.Inline_response_200_28
import io.swagger.client.model.Inline_response_200_2
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class VariableApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all Variables
   * Get all Variables
   * @param id id
   * @param clientId client_id
   * @param parentId parent_id
   * @param name name
   * @param variableCategoryId variable_category_id
   * @param defaultUnitId default_unit_id
   * @param combinationOperation combination_operation
   * @param fillingValue filling_value
   * @param maximumAllowedValue maximum_allowed_value
   * @param minimumAllowedValue minimum_allowed_value
   * @param onsetDelay onset_delay
   * @param durationOfAction duration_of_action
   * @param public public
   * @param causeOnly cause_only
   * @param mostCommonValue most_common_value
   * @param mostCommonUnitId most_common_unit_id
   * @param standardDeviation standard_deviation
   * @param variance variance
   * @param mean mean
   * @param median median
   * @param numberOfMeasurements number_of_measurements
   * @param numberOfUniqueValues number_of_unique_values
   * @param skewness skewness
   * @param kurtosis kurtosis
   * @param latitude latitude
   * @param longitude longitude
   * @param location location
   * @param status status
   * @param errorMessage error_message
   * @param lastSuccessfulUpdateTime last_successful_update_time
   * @param createdAt created_at
   * @param updatedAt updated_at
   * @param productUrl product_url
   * @param imageUrl image_url
   * @param price price
   * @param numberOfUserVariables number_of_user_variables
   * @param outcome outcome
   * @param minimumRecordedValue minimum_recorded_value
   * @param maximumRecordedValue maximum_recorded_value
   * @param limit limit
   * @param offset offset
   * @param sort sort
   * @return Inline_response_200_27
   */
  def variablesGet (id: Integer, clientId: String, parentId: Integer, name: String, variableCategoryId: Integer, defaultUnitId: Integer, combinationOperation: String, fillingValue: Number, maximumAllowedValue: Number, minimumAllowedValue: Number, onsetDelay: Integer, durationOfAction: Integer, public: Integer, causeOnly: Boolean, mostCommonValue: Number, mostCommonUnitId: Integer, standardDeviation: Number, variance: Number, mean: Number, median: Number, numberOfMeasurements: Number, numberOfUniqueValues: Number, skewness: Number, kurtosis: Number, latitude: Number, longitude: Number, location: String, status: String, errorMessage: String, lastSuccessfulUpdateTime: String, createdAt: String, updatedAt: String, productUrl: String, imageUrl: String, price: Number, numberOfUserVariables: Integer, outcome: Boolean, minimumRecordedValue: Number, maximumRecordedValue: Number, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_27] = {
    // create path and map variables
    val path = "/variables".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(id) != "null") queryParams += "id" -> id.toString
    if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
    if(String.valueOf(parentId) != "null") queryParams += "parent_id" -> parentId.toString
    if(String.valueOf(name) != "null") queryParams += "name" -> name.toString
    if(String.valueOf(variableCategoryId) != "null") queryParams += "variable_category_id" -> variableCategoryId.toString
    if(String.valueOf(defaultUnitId) != "null") queryParams += "default_unit_id" -> defaultUnitId.toString
    if(String.valueOf(combinationOperation) != "null") queryParams += "combination_operation" -> combinationOperation.toString
    if(String.valueOf(fillingValue) != "null") queryParams += "filling_value" -> fillingValue.toString
    if(String.valueOf(maximumAllowedValue) != "null") queryParams += "maximum_allowed_value" -> maximumAllowedValue.toString
    if(String.valueOf(minimumAllowedValue) != "null") queryParams += "minimum_allowed_value" -> minimumAllowedValue.toString
    if(String.valueOf(onsetDelay) != "null") queryParams += "onset_delay" -> onsetDelay.toString
    if(String.valueOf(durationOfAction) != "null") queryParams += "duration_of_action" -> durationOfAction.toString
    if(String.valueOf(public) != "null") queryParams += "public" -> public.toString
    if(String.valueOf(causeOnly) != "null") queryParams += "cause_only" -> causeOnly.toString
    if(String.valueOf(mostCommonValue) != "null") queryParams += "most_common_value" -> mostCommonValue.toString
    if(String.valueOf(mostCommonUnitId) != "null") queryParams += "most_common_unit_id" -> mostCommonUnitId.toString
    if(String.valueOf(standardDeviation) != "null") queryParams += "standard_deviation" -> standardDeviation.toString
    if(String.valueOf(variance) != "null") queryParams += "variance" -> variance.toString
    if(String.valueOf(mean) != "null") queryParams += "mean" -> mean.toString
    if(String.valueOf(median) != "null") queryParams += "median" -> median.toString
    if(String.valueOf(numberOfMeasurements) != "null") queryParams += "number_of_measurements" -> numberOfMeasurements.toString
    if(String.valueOf(numberOfUniqueValues) != "null") queryParams += "number_of_unique_values" -> numberOfUniqueValues.toString
    if(String.valueOf(skewness) != "null") queryParams += "skewness" -> skewness.toString
    if(String.valueOf(kurtosis) != "null") queryParams += "kurtosis" -> kurtosis.toString
    if(String.valueOf(latitude) != "null") queryParams += "latitude" -> latitude.toString
    if(String.valueOf(longitude) != "null") queryParams += "longitude" -> longitude.toString
    if(String.valueOf(location) != "null") queryParams += "location" -> location.toString
    if(String.valueOf(status) != "null") queryParams += "status" -> status.toString
    if(String.valueOf(errorMessage) != "null") queryParams += "error_message" -> errorMessage.toString
    if(String.valueOf(lastSuccessfulUpdateTime) != "null") queryParams += "last_successful_update_time" -> lastSuccessfulUpdateTime.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
    if(String.valueOf(productUrl) != "null") queryParams += "product_url" -> productUrl.toString
    if(String.valueOf(imageUrl) != "null") queryParams += "image_url" -> imageUrl.toString
    if(String.valueOf(price) != "null") queryParams += "price" -> price.toString
    if(String.valueOf(numberOfUserVariables) != "null") queryParams += "number_of_user_variables" -> numberOfUserVariables.toString
    if(String.valueOf(outcome) != "null") queryParams += "outcome" -> outcome.toString
    if(String.valueOf(minimumRecordedValue) != "null") queryParams += "minimum_recorded_value" -> minimumRecordedValue.toString
    if(String.valueOf(maximumRecordedValue) != "null") queryParams += "maximum_recorded_value" -> maximumRecordedValue.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_27]).asInstanceOf[Inline_response_200_27])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store Variable
   * Store Variable
   * @param body Variable that should be stored
   * @return Inline_response_200_28
   */
  def variablesPost (body: Variable) : Option[Inline_response_200_28] = {
    // create path and map variables
    val path = "/variables".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_28]).asInstanceOf[Inline_response_200_28])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Variable
   * Get Variable
   * @param id id of Variable
   * @return Inline_response_200_28
   */
  def variablesIdGet (id: Integer) : Option[Inline_response_200_28] = {
    // create path and map variables
    val path = "/variables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_28]).asInstanceOf[Inline_response_200_28])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update Variable
   * Update Variable
   * @param id id of Variable
   * @param body Variable that should be updated
   * @return Inline_response_200_2
   */
  def variablesIdPut (id: Integer, body: Variable) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/variables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
   * Delete Variable
   * Delete Variable
   * @param id id of Variable
   * @return Inline_response_200_2
   */
  def variablesIdDelete (id: Integer) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/variables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
