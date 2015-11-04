package io.swagger.client.api

import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200_21
import io.swagger.client.model.Inline_response_200_22
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
   * @param clientId client_id
   * @param variableId variable_id
   * @param defaultUnitId default_unit_id
   * @param minimumAllowedValue minimum_allowed_value
   * @param maximumAllowedValue maximum_allowed_value
   * @param fillingValue filling_value
   * @param joinWith join_with
   * @param onsetDelay onset_delay
   * @param durationOfAction duration_of_action
   * @param variableCategoryId variable_category_id
   * @param updated updated
   * @param public public
   * @param causeOnly cause_only
   * @param fillingType filling_type
   * @param numberOfMeasurements number_of_measurements
   * @param numberOfProcessedMeasurements number_of_processed_measurements
   * @param measurementsAtLastAnalysis measurements_at_last_analysis
   * @param lastUnitId last_unit_id
   * @param lastOriginalUnitId last_original_unit_id
   * @param lastOriginalValue last_original_value
   * @param lastValue last_value
   * @param lastSourceId last_source_id
   * @param numberOfCorrelations number_of_correlations
   * @param status status
   * @param errorMessage error_message
   * @param lastSuccessfulUpdateTime last_successful_update_time
   * @param standardDeviation standard_deviation
   * @param variance variance
   * @param minimumRecordedDailyValue minimum_recorded_daily_value
   * @param maximumRecordedDailyValue maximum_recorded_daily_value
   * @param mean mean
   * @param median median
   * @param mostCommonUnitId most_common_unit_id
   * @param mostCommonValue most_common_value
   * @param numberOfUniqueDailyValues number_of_unique_daily_values
   * @param numberOfChanges number_of_changes
   * @param skewness skewness
   * @param kurtosis kurtosis
   * @param latitude latitude
   * @param longitude longitude
   * @param location location
   * @param createdAt created_at
   * @param updatedAt updated_at
   * @param outcome outcome
   * @param sources sources
   * @param earliestSourceTime earliest_source_time
   * @param latestSourceTime latest_source_time
   * @param earliestMeasurementTime earliest_measurement_time
   * @param latestMeasurementTime latest_measurement_time
   * @param earliestFillingTime earliest_filling_time
   * @param latestFillingTime latest_filling_time
   * @param limit limit
   * @param offset offset
   * @param sort sort
   * @return Inline_response_200_21
   */
  def userVariablesGet (clientId: String, variableId: Integer, defaultUnitId: Integer, minimumAllowedValue: Number, maximumAllowedValue: Number, fillingValue: Number, joinWith: Integer, onsetDelay: Integer, durationOfAction: Integer, variableCategoryId: Integer, updated: Integer, public: Integer, causeOnly: Boolean, fillingType: String, numberOfMeasurements: Integer, numberOfProcessedMeasurements: Integer, measurementsAtLastAnalysis: Integer, lastUnitId: Integer, lastOriginalUnitId: Integer, lastOriginalValue: Integer, lastValue: Number, lastSourceId: Integer, numberOfCorrelations: Integer, status: String, errorMessage: String, lastSuccessfulUpdateTime: String, standardDeviation: Number, variance: Number, minimumRecordedDailyValue: Number, maximumRecordedDailyValue: Number, mean: Number, median: Number, mostCommonUnitId: Integer, mostCommonValue: Number, numberOfUniqueDailyValues: Number, numberOfChanges: Integer, skewness: Number, kurtosis: Number, latitude: Number, longitude: Number, location: String, createdAt: String, updatedAt: String, outcome: Boolean, sources: String, earliestSourceTime: Integer, latestSourceTime: Integer, earliestMeasurementTime: Integer, latestMeasurementTime: Integer, earliestFillingTime: Integer, latestFillingTime: Integer, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_21] = {
    // create path and map variables
    val path = "/userVariables".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
    if(String.valueOf(variableId) != "null") queryParams += "variable_id" -> variableId.toString
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
    if(String.valueOf(lastSourceId) != "null") queryParams += "last_source_id" -> lastSourceId.toString
    if(String.valueOf(numberOfCorrelations) != "null") queryParams += "number_of_correlations" -> numberOfCorrelations.toString
    if(String.valueOf(status) != "null") queryParams += "status" -> status.toString
    if(String.valueOf(errorMessage) != "null") queryParams += "error_message" -> errorMessage.toString
    if(String.valueOf(lastSuccessfulUpdateTime) != "null") queryParams += "last_successful_update_time" -> lastSuccessfulUpdateTime.toString
    if(String.valueOf(standardDeviation) != "null") queryParams += "standard_deviation" -> standardDeviation.toString
    if(String.valueOf(variance) != "null") queryParams += "variance" -> variance.toString
    if(String.valueOf(minimumRecordedDailyValue) != "null") queryParams += "minimum_recorded_daily_value" -> minimumRecordedDailyValue.toString
    if(String.valueOf(maximumRecordedDailyValue) != "null") queryParams += "maximum_recorded_daily_value" -> maximumRecordedDailyValue.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_21]).asInstanceOf[Inline_response_200_21])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store UserVariable
   * Store UserVariable
   * @param body UserVariable that should be stored
   * @return Inline_response_200_22
   */
  def userVariablesPost (body: UserVariable) : Option[Inline_response_200_22] = {
    // create path and map variables
    val path = "/userVariables".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_22]).asInstanceOf[Inline_response_200_22])
         
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
   * @return Inline_response_200_22
   */
  def userVariablesIdGet (id: Integer) : Option[Inline_response_200_22] = {
    // create path and map variables
    val path = "/userVariables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_22]).asInstanceOf[Inline_response_200_22])
         
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
   * @param body UserVariable that should be updated
   * @return Inline_response_200_2
   */
  def userVariablesIdPut (id: Integer, body: UserVariable) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/userVariables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
   * Delete UserVariable
   * Delete UserVariable
   * @param id id of UserVariable
   * @return Inline_response_200_2
   */
  def userVariablesIdDelete (id: Integer) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/userVariables/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
