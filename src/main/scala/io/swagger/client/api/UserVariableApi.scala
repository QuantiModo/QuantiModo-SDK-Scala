package io.swagger.client.api

import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200_9
import io.swagger.client.model.Inline_response_200_30
import io.swagger.client.model.UserVariable
import io.swagger.client.model.Inline_response_200_2
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class UserVariableApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all UserVariables
   * Get all UserVariables
   * @param accessToken User&#39;s OAuth2 access token
   * @param clientId The ID of the client application which last created or updated this user variable
   * @param parentId ID of the parent variable if this variable has any parent
   * @param variableId ID of variable
   * @param userId User ID
   * @param defaultUnitId D of unit to use for this variable
   * @param minimumAllowedValue Minimum reasonable value for this variable (uses default unit)
   * @param maximumAllowedValue Maximum reasonable value for this variable (uses default unit)
   * @param fillingValue Value for replacing null measurements
   * @param joinWith The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables
   * @param onsetDelay Estimated number of seconds that pass before a stimulus produces a perceivable effect
   * @param durationOfAction Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect
   * @param variableCategoryId ID of variable category
   * @param updated updated
   * @param public Is variable public
   * @param causeOnly A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user
   * @param fillingType 0 -&gt; No filling, 1 -&gt; Use filling-value
   * @param numberOfMeasurements Number of measurements
   * @param numberOfProcessedMeasurements Number of processed measurements
   * @param measurementsAtLastAnalysis Number of measurements at last analysis
   * @param lastUnitId ID of last Unit
   * @param lastOriginalUnitId ID of last original Unit
   * @param lastOriginalValue Last original value which is stored
   * @param lastValue Last Value
   * @param lastOriginalValue2 Last original value which is stored
   * @param lastSourceId ID of last source
   * @param numberOfCorrelations Number of correlations for this variable
   * @param status status
   * @param errorMessage error_message
   * @param lastSuccessfulUpdateTime When this variable or its settings were last updated
   * @param standardDeviation Standard deviation
   * @param variance Variance
   * @param minimumRecordedValue Minimum recorded value of this variable
   * @param maximumRecordedValue Maximum recorded value of this variable
   * @param mean Mean
   * @param median Median
   * @param mostCommonUnitId Most common Unit ID
   * @param mostCommonValue Most common value
   * @param numberOfUniqueDailyValues Number of unique daily values
   * @param numberOfChanges Number of changes
   * @param skewness Skewness
   * @param kurtosis Kurtosis
   * @param latitude Latitude
   * @param longitude Longitude
   * @param location Location
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param outcome Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables
   * @param sources Comma-separated list of source names to limit variables to those sources
   * @param earliestSourceTime Earliest source time
   * @param latestSourceTime Latest source time
   * @param earliestMeasurementTime Earliest measurement time
   * @param latestMeasurementTime Latest measurement time
   * @param earliestFillingTime Earliest filling time
   * @param latestFillingTime Latest filling time
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_9
   */
  def userVariablesGet (accessToken: String, clientId: String, parentId: Integer, variableId: Integer, userId: Integer, defaultUnitId: Integer, minimumAllowedValue: Number, maximumAllowedValue: Number, fillingValue: Number, joinWith: Integer, onsetDelay: Integer, durationOfAction: Integer, variableCategoryId: Integer, updated: Integer, public: Integer, causeOnly: Boolean, fillingType: String, numberOfMeasurements: Integer, numberOfProcessedMeasurements: Integer, measurementsAtLastAnalysis: Integer, lastUnitId: Integer, lastOriginalUnitId: Integer, lastOriginalValue: Integer, lastValue: Number, lastOriginalValue2: Number, lastSourceId: Integer, numberOfCorrelations: Integer, status: String, errorMessage: String, lastSuccessfulUpdateTime: String, standardDeviation: Number, variance: Number, minimumRecordedValue: Number, maximumRecordedValue: Number, mean: Number, median: Number, mostCommonUnitId: Integer, mostCommonValue: Number, numberOfUniqueDailyValues: Number, numberOfChanges: Integer, skewness: Number, kurtosis: Number, latitude: Number, longitude: Number, location: String, createdAt: String, updatedAt: String, outcome: Boolean, sources: String, earliestSourceTime: Integer, latestSourceTime: Integer, earliestMeasurementTime: Integer, latestMeasurementTime: Integer, earliestFillingTime: Integer, latestFillingTime: Integer, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_9] = {
    // create path and map variables
    val path = "/userVariables".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
    if(String.valueOf(parentId) != "null") queryParams += "parent_id" -> parentId.toString
    if(String.valueOf(variableId) != "null") queryParams += "variable_id" -> variableId.toString
    if(String.valueOf(userId) != "null") queryParams += "user_id" -> userId.toString
    if(String.valueOf(defaultUnitId) != "null") queryParams += "default_unit_id" -> defaultUnitId.toString
    if(String.valueOf(minimumAllowedValue) != "null") queryParams += "minimum_allowed_value" -> minimumAllowedValue.toString
    if(String.valueOf(maximumAllowedValue) != "null") queryParams += "maximum_allowed_value" -> maximumAllowedValue.toString
    if(String.valueOf(fillingValue) != "null") queryParams += "filling_value" -> fillingValue.toString
    if(String.valueOf(joinWith) != "null") queryParams += "join_with" -> joinWith.toString
    if(String.valueOf(onsetDelay) != "null") queryParams += "onset_delay" -> onsetDelay.toString
    if(String.valueOf(durationOfAction) != "null") queryParams += "duration_of_action" -> durationOfAction.toString
    if(String.valueOf(variableCategoryId) != "null") queryParams += "variable_category_id" -> variableCategoryId.toString
    if(String.valueOf(updated) != "null") queryParams += "updated" -> updated.toString
    if(String.valueOf(public) != "null") queryParams += "public" -> public.toString
    if(String.valueOf(causeOnly) != "null") queryParams += "cause_only" -> causeOnly.toString
    if(String.valueOf(fillingType) != "null") queryParams += "filling_type" -> fillingType.toString
    if(String.valueOf(numberOfMeasurements) != "null") queryParams += "number_of_measurements" -> numberOfMeasurements.toString
    if(String.valueOf(numberOfProcessedMeasurements) != "null") queryParams += "number_of_processed_measurements" -> numberOfProcessedMeasurements.toString
    if(String.valueOf(measurementsAtLastAnalysis) != "null") queryParams += "measurements_at_last_analysis" -> measurementsAtLastAnalysis.toString
    if(String.valueOf(lastUnitId) != "null") queryParams += "last_unit_id" -> lastUnitId.toString
    if(String.valueOf(lastOriginalUnitId) != "null") queryParams += "last_original_unit_id" -> lastOriginalUnitId.toString
    if(String.valueOf(lastOriginalValue) != "null") queryParams += "last_original_value" -> lastOriginalValue.toString
    if(String.valueOf(lastValue) != "null") queryParams += "last_value" -> lastValue.toString
    if(String.valueOf(lastOriginalValue2) != "null") queryParams += "last_original_value" -> lastOriginalValue2.toString
    if(String.valueOf(lastSourceId) != "null") queryParams += "last_source_id" -> lastSourceId.toString
    if(String.valueOf(numberOfCorrelations) != "null") queryParams += "number_of_correlations" -> numberOfCorrelations.toString
    if(String.valueOf(status) != "null") queryParams += "status" -> status.toString
    if(String.valueOf(errorMessage) != "null") queryParams += "error_message" -> errorMessage.toString
    if(String.valueOf(lastSuccessfulUpdateTime) != "null") queryParams += "last_successful_update_time" -> lastSuccessfulUpdateTime.toString
    if(String.valueOf(standardDeviation) != "null") queryParams += "standard_deviation" -> standardDeviation.toString
    if(String.valueOf(variance) != "null") queryParams += "variance" -> variance.toString
    if(String.valueOf(minimumRecordedValue) != "null") queryParams += "minimum_recorded_value" -> minimumRecordedValue.toString
    if(String.valueOf(maximumRecordedValue) != "null") queryParams += "maximum_recorded_value" -> maximumRecordedValue.toString
    if(String.valueOf(mean) != "null") queryParams += "mean" -> mean.toString
    if(String.valueOf(median) != "null") queryParams += "median" -> median.toString
    if(String.valueOf(mostCommonUnitId) != "null") queryParams += "most_common_unit_id" -> mostCommonUnitId.toString
    if(String.valueOf(mostCommonValue) != "null") queryParams += "most_common_value" -> mostCommonValue.toString
    if(String.valueOf(numberOfUniqueDailyValues) != "null") queryParams += "number_of_unique_daily_values" -> numberOfUniqueDailyValues.toString
    if(String.valueOf(numberOfChanges) != "null") queryParams += "number_of_changes" -> numberOfChanges.toString
    if(String.valueOf(skewness) != "null") queryParams += "skewness" -> skewness.toString
    if(String.valueOf(kurtosis) != "null") queryParams += "kurtosis" -> kurtosis.toString
    if(String.valueOf(latitude) != "null") queryParams += "latitude" -> latitude.toString
    if(String.valueOf(longitude) != "null") queryParams += "longitude" -> longitude.toString
    if(String.valueOf(location) != "null") queryParams += "location" -> location.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
    if(String.valueOf(outcome) != "null") queryParams += "outcome" -> outcome.toString
    if(String.valueOf(sources) != "null") queryParams += "sources" -> sources.toString
    if(String.valueOf(earliestSourceTime) != "null") queryParams += "earliest_source_time" -> earliestSourceTime.toString
    if(String.valueOf(latestSourceTime) != "null") queryParams += "latest_source_time" -> latestSourceTime.toString
    if(String.valueOf(earliestMeasurementTime) != "null") queryParams += "earliest_measurement_time" -> earliestMeasurementTime.toString
    if(String.valueOf(latestMeasurementTime) != "null") queryParams += "latest_measurement_time" -> latestMeasurementTime.toString
    if(String.valueOf(earliestFillingTime) != "null") queryParams += "earliest_filling_time" -> earliestFillingTime.toString
    if(String.valueOf(latestFillingTime) != "null") queryParams += "latest_filling_time" -> latestFillingTime.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_9]).asInstanceOf[Inline_response_200_9])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store UserVariable
   * Users can change things like the display name for a variable. They can also change the parameters used in analysis of that variable such as the expected duration of action for a variable to have an effect, the estimated delay before the onset of action. In order to filter out erroneous data, they are able to set the maximum and minimum reasonable daily values for a variable.
   * @param accessToken User&#39;s OAuth2 access token
   * @param body UserVariable that should be stored
   * @return Inline_response_200_30
   */
  def userVariablesPost (accessToken: String, body: UserVariable) : Option[Inline_response_200_30] = {
    // create path and map variables
    val path = "/userVariables".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_30]).asInstanceOf[Inline_response_200_30])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get UserVariable
   * Get UserVariable
   * @param id id of UserVariable
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_30
   */
  def userVariablesIdGet (id: Integer, accessToken: String) : Option[Inline_response_200_30] = {
    // create path and map variables
    val path = "/userVariables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_30]).asInstanceOf[Inline_response_200_30])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update UserVariable
   * Update UserVariable
   * @param id id of UserVariable
   * @param accessToken User&#39;s OAuth2 access token
   * @param body UserVariable that should be updated
   * @return Inline_response_200_2
   */
  def userVariablesIdPut (id: Integer, accessToken: String, body: UserVariable) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/userVariables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
   * Delete UserVariable
   * Delete UserVariable
   * @param id id of UserVariable
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_2
   */
  def userVariablesIdDelete (id: Integer, accessToken: String) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/userVariables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
