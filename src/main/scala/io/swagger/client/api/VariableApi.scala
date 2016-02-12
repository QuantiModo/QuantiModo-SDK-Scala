package io.swagger.client.api

import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200_34
import io.swagger.client.model.Variable
import io.swagger.client.model.Inline_response_200_35
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
   * @param accessToken User&#39;s OAuth2 access token
   * @param id id
   * @param clientId The ID of the client application which last created or updated this common variable
   * @param parentId ID of the parent variable if this variable has any parent
   * @param name User-defined variable display name
   * @param variableCategoryId Variable category ID
   * @param defaultUnitId ID of the default unit for the variable
   * @param combinationOperation How to combine values of this variable (for instance, to see a summary of the values over a month) SUM or MEAN
   * @param fillingValue Value for replacing null measurements
   * @param maximumAllowedValue Maximum reasonable value for this variable (uses default unit)
   * @param minimumAllowedValue Minimum reasonable value for this variable (uses default unit)
   * @param onsetDelay Estimated number of seconds that pass before a stimulus produces a perceivable effect
   * @param durationOfAction Estimated number of seconds following the onset delay in which a stimulus produces a perceivable effect
   * @param public Is variable public
   * @param causeOnly A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user
   * @param mostCommonValue Most common value
   * @param mostCommonUnitId Most common Unit
   * @param standardDeviation Standard Deviation
   * @param variance Average variance for this variable based on all user data
   * @param mean Mean for this variable based on all user data
   * @param median Median for this variable based on all user data
   * @param numberOfMeasurements Number of measurements for this variable based on all user data
   * @param numberOfUniqueValues Number of unique values for this variable based on all user data
   * @param skewness Skewness for this variable based on all user data
   * @param kurtosis Kurtosis for this variable based on all user data
   * @param status status
   * @param errorMessage error_message
   * @param lastSuccessfulUpdateTime When this variable or its settings were last updated
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param productUrl Product URL
   * @param imageUrl Image URL
   * @param price Price
   * @param numberOfUserVariables Number of users who have data for this variable
   * @param outcome Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables.
   * @param minimumRecordedValue Minimum recorded value of this variable based on all user data
   * @param maximumRecordedValue Maximum recorded value of this variable based on all user data
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort records by a given field name. If the field name is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_34
   */
  def variablesGet (accessToken: String, id: Integer, clientId: String, parentId: Integer, name: String, variableCategoryId: Integer, defaultUnitId: Integer, combinationOperation: String, fillingValue: Number, maximumAllowedValue: Number, minimumAllowedValue: Number, onsetDelay: Integer, durationOfAction: Integer, public: Integer, causeOnly: Boolean, mostCommonValue: Number, mostCommonUnitId: Integer, standardDeviation: Number, variance: Number, mean: Number, median: Number, numberOfMeasurements: Number, numberOfUniqueValues: Number, skewness: Number, kurtosis: Number, status: String, errorMessage: String, lastSuccessfulUpdateTime: String, createdAt: String, updatedAt: String, productUrl: String, imageUrl: String, price: Number, numberOfUserVariables: Integer, outcome: Boolean, minimumRecordedValue: Number, maximumRecordedValue: Number, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_34] = {
    // create path and map variables
    val path = "/variables".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_34]).asInstanceOf[Inline_response_200_34])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store Variable
   * Allows the client to create a new variable in the `variables` table.
   * @param accessToken User&#39;s OAuth2 access token
   * @param body Variable that should be stored
   * @return Inline_response_200_35
   */
  def variablesPost (accessToken: String, body: Variable) : Option[Inline_response_200_35] = {
    // create path and map variables
    val path = "/variables".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_35]).asInstanceOf[Inline_response_200_35])
         
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
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_35
   */
  def variablesIdGet (id: Integer, accessToken: String) : Option[Inline_response_200_35] = {
    // create path and map variables
    val path = "/variables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_35]).asInstanceOf[Inline_response_200_35])
         
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
   * @param accessToken User&#39;s OAuth2 access token
   * @param body Variable that should be updated
   * @return Inline_response_200_2
   */
  def variablesIdPut (id: Integer, accessToken: String, body: Variable) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/variables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    

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
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_2
   */
  def variablesIdDelete (id: Integer, accessToken: String) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/variables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    

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
