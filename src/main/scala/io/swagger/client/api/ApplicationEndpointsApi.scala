package io.swagger.client.api

import io.swagger.client.model.Inline_response_200_3
import io.swagger.client.model.Inline_response_200_4
import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200_5
import io.swagger.client.model.Inline_response_200_6
import io.swagger.client.model.Inline_response_200_7
import io.swagger.client.model.Inline_response_200_8
import io.swagger.client.model.Inline_response_200_9
import io.swagger.client.model.Inline_response_200_10
import io.swagger.client.model.Inline_response_200_11
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class ApplicationEndpointsApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all Connections
   * Get all Connections
   * @param accessToken Application&#39;s OAuth2 access token
   * @param connectorId The id for the connector data source for which the connection is connected
   * @param connectStatus Indicates whether a connector is currently connected to a service for a user.
   * @param connectError Error message if there is a problem with authorizing this connection.
   * @param updateRequestedAt Time at which an update was requested by a user.
   * @param updateStatus Indicates whether a connector is currently updated.
   * @param updateError Indicates if there was an error during the update.
   * @param lastSuccessfulUpdatedAt The time at which the connector was last successfully updated.
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_3
   */
  def applicationConnectionsGet (accessToken: String, connectorId: Integer, connectStatus: String, connectError: String, updateRequestedAt: String, updateStatus: String, updateError: String, lastSuccessfulUpdatedAt: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_3] = {
    // create path and map variables
    val path = "/application/connections".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
    if(String.valueOf(connectStatus) != "null") queryParams += "connect_status" -> connectStatus.toString
    if(String.valueOf(connectError) != "null") queryParams += "connect_error" -> connectError.toString
    if(String.valueOf(updateRequestedAt) != "null") queryParams += "update_requested_at" -> updateRequestedAt.toString
    if(String.valueOf(updateStatus) != "null") queryParams += "update_status" -> updateStatus.toString
    if(String.valueOf(updateError) != "null") queryParams += "update_error" -> updateError.toString
    if(String.valueOf(lastSuccessfulUpdatedAt) != "null") queryParams += "last_successful_updated_at" -> lastSuccessfulUpdatedAt.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_3]).asInstanceOf[Inline_response_200_3])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get all Credentials
   * Get all Credentials
   * @param accessToken Application&#39;s OAuth2 access token
   * @param connectorId The id for the connector data source from which the credential was obtained
   * @param attrKey Attribute name such as token, userid, username, or password
   * @param attrValue Encrypted value for the attribute specified
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_4
   */
  def applicationCredentialsGet (accessToken: String, connectorId: Integer, attrKey: String, attrValue: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_4] = {
    // create path and map variables
    val path = "/application/credentials".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
    if(String.valueOf(attrKey) != "null") queryParams += "attr_key" -> attrKey.toString
    if(String.valueOf(attrValue) != "null") queryParams += "attr_value" -> attrValue.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_4]).asInstanceOf[Inline_response_200_4])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get measurements for all users using your application
   * Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten.
   * @param accessToken Application&#39;s OAuth2 access token
   * @param clientId The ID of the client application which originally stored the measurement
   * @param connectorId The id for the connector data source from which the measurement was obtained
   * @param variableId ID of the variable for which we are creating the measurement records
   * @param sourceId Application or device used to record the measurement values
   * @param startTime start time for the measurement event. Use ISO 8601 datetime format
   * @param value The value of the measurement after conversion to the default unit for that variable
   * @param unitId The default unit id for the variable
   * @param originalValue Unconverted value of measurement as originally posted (before conversion to default unit)
   * @param originalUnitId Unit id of the measurement as originally submitted
   * @param duration Duration of the event being measurement in seconds
   * @param note An optional note the user may include with their measurement
   * @param latitude Latitude at which the measurement was taken
   * @param longitude Longitude at which the measurement was taken
   * @param location Optional human readable name for the location where the measurement was recorded
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param error An error message if there is a problem with the measurement
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_5
   */
  def applicationMeasurementsGet (accessToken: String, clientId: String, connectorId: Integer, variableId: Integer, sourceId: Integer, startTime: String, value: Number, unitId: Integer, originalValue: Number, originalUnitId: Integer, duration: Integer, note: String, latitude: Number, longitude: Number, location: String, createdAt: String, updatedAt: String, error: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_5] = {
    // create path and map variables
    val path = "/application/measurements".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
    if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
    if(String.valueOf(variableId) != "null") queryParams += "variable_id" -> variableId.toString
    if(String.valueOf(sourceId) != "null") queryParams += "source_id" -> sourceId.toString
    if(String.valueOf(startTime) != "null") queryParams += "start_time" -> startTime.toString
    if(String.valueOf(value) != "null") queryParams += "value" -> value.toString
    if(String.valueOf(unitId) != "null") queryParams += "unit_id" -> unitId.toString
    if(String.valueOf(originalValue) != "null") queryParams += "original_value" -> originalValue.toString
    if(String.valueOf(originalUnitId) != "null") queryParams += "original_unit_id" -> originalUnitId.toString
    if(String.valueOf(duration) != "null") queryParams += "duration" -> duration.toString
    if(String.valueOf(note) != "null") queryParams += "note" -> note.toString
    if(String.valueOf(latitude) != "null") queryParams += "latitude" -> latitude.toString
    if(String.valueOf(longitude) != "null") queryParams += "longitude" -> longitude.toString
    if(String.valueOf(location) != "null") queryParams += "location" -> location.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
    if(String.valueOf(error) != "null") queryParams += "error" -> error.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_5]).asInstanceOf[Inline_response_200_5])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get tracking reminders
   * Get the variable id, frequency, and default value for the user tracking reminders
   * @param accessToken User&#39;s OAuth2 access token
   * @param clientId The ID of the client application which last created or updated this trackingReminder
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_6
   */
  def applicationTrackingRemindersGet (accessToken: String, clientId: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_6] = {
    // create path and map variables
    val path = "/application/trackingReminders".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_6]).asInstanceOf[Inline_response_200_6])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get all Updates
   * Get all Updates
   * @param accessToken Application&#39;s OAuth2 access token
   * @param connectorId connector_id
   * @param numberOfMeasurements number_of_measurements
   * @param success success
   * @param message message
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_7
   */
  def applicationUpdatesGet (accessToken: String, connectorId: Integer, numberOfMeasurements: Integer, success: Boolean, message: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_7] = {
    // create path and map variables
    val path = "/application/updates".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
    if(String.valueOf(numberOfMeasurements) != "null") queryParams += "number_of_measurements" -> numberOfMeasurements.toString
    if(String.valueOf(success) != "null") queryParams += "success" -> success.toString
    if(String.valueOf(message) != "null") queryParams += "message" -> message.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_7]).asInstanceOf[Inline_response_200_7])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get all UserVariableRelationships
   * Get all UserVariableRelationships
   * @param accessToken User&#39;s OAuth2 access token
   * @param id id
   * @param confidenceLevel Our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors
   * @param confidenceScore A quantitative representation of our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors
   * @param direction Direction is positive if higher predictor values generally precede higher outcome values. Direction is negative if higher predictor values generally precede lower outcome values.
   * @param durationOfAction Estimated number of seconds following the onset delay in which a stimulus produces a perceivable effect
   * @param errorMessage error_message
   * @param onsetDelay Estimated number of seconds that pass before a stimulus produces a perceivable effect
   * @param outcomeVariableId Variable ID for the outcome variable
   * @param predictorVariableId Variable ID for the predictor variable
   * @param predictorUnitId ID for default unit of the predictor variable
   * @param sinnRank A value representative of the relevance of this predictor relative to other predictors of this outcome.  Usually used for relevancy sorting.
   * @param strengthLevel Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores.
   * @param strengthScore A value represented to the size of the effect which the predictor appears to have on the outcome.
   * @param vote vote
   * @param valuePredictingHighOutcome Value for the predictor variable (in it&#39;s default unit) which typically precedes an above average outcome value
   * @param valuePredictingLowOutcome Value for the predictor variable (in it&#39;s default unit) which typically precedes a below average outcome value
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_8
   */
  def applicationUserVariableRelationshipsGet (accessToken: String, id: Integer, confidenceLevel: String, confidenceScore: Number, direction: String, durationOfAction: Integer, errorMessage: String, onsetDelay: Integer, outcomeVariableId: Integer, predictorVariableId: Integer, predictorUnitId: Integer, sinnRank: Number, strengthLevel: String, strengthScore: Number, vote: String, valuePredictingHighOutcome: Number, valuePredictingLowOutcome: Number, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_8] = {
    // create path and map variables
    val path = "/application/userVariableRelationships".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(id) != "null") queryParams += "id" -> id.toString
    if(String.valueOf(confidenceLevel) != "null") queryParams += "confidence_level" -> confidenceLevel.toString
    if(String.valueOf(confidenceScore) != "null") queryParams += "confidence_score" -> confidenceScore.toString
    if(String.valueOf(direction) != "null") queryParams += "direction" -> direction.toString
    if(String.valueOf(durationOfAction) != "null") queryParams += "duration_of_action" -> durationOfAction.toString
    if(String.valueOf(errorMessage) != "null") queryParams += "error_message" -> errorMessage.toString
    if(String.valueOf(onsetDelay) != "null") queryParams += "onset_delay" -> onsetDelay.toString
    if(String.valueOf(outcomeVariableId) != "null") queryParams += "outcome_variable_id" -> outcomeVariableId.toString
    if(String.valueOf(predictorVariableId) != "null") queryParams += "predictor_variable_id" -> predictorVariableId.toString
    if(String.valueOf(predictorUnitId) != "null") queryParams += "predictor_unit_id" -> predictorUnitId.toString
    if(String.valueOf(sinnRank) != "null") queryParams += "sinn_rank" -> sinnRank.toString
    if(String.valueOf(strengthLevel) != "null") queryParams += "strength_level" -> strengthLevel.toString
    if(String.valueOf(strengthScore) != "null") queryParams += "strength_score" -> strengthScore.toString
    if(String.valueOf(vote) != "null") queryParams += "vote" -> vote.toString
    if(String.valueOf(valuePredictingHighOutcome) != "null") queryParams += "value_predicting_high_outcome" -> valuePredictingHighOutcome.toString
    if(String.valueOf(valuePredictingLowOutcome) != "null") queryParams += "value_predicting_low_outcome" -> valuePredictingLowOutcome.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_8]).asInstanceOf[Inline_response_200_8])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get all UserVariables
   * Get all UserVariables
   * @param accessToken User&#39;s OAuth2 access token
   * @param clientId The ID of the client application which last created or updated this user variable
   * @param parentId ID of the parent variable if this variable has any parent
   * @param variableId ID of variable
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
  def applicationUserVariablesGet (accessToken: String, clientId: String, parentId: Integer, variableId: Integer, defaultUnitId: Integer, minimumAllowedValue: Number, maximumAllowedValue: Number, fillingValue: Number, joinWith: Integer, onsetDelay: Integer, durationOfAction: Integer, variableCategoryId: Integer, updated: Integer, public: Integer, causeOnly: Boolean, fillingType: String, numberOfMeasurements: Integer, numberOfProcessedMeasurements: Integer, measurementsAtLastAnalysis: Integer, lastUnitId: Integer, lastOriginalUnitId: Integer, lastOriginalValue: Integer, lastValue: Number, lastOriginalValue2: Number, lastSourceId: Integer, numberOfCorrelations: Integer, status: String, errorMessage: String, lastSuccessfulUpdateTime: String, standardDeviation: Number, variance: Number, minimumRecordedValue: Number, maximumRecordedValue: Number, mean: Number, median: Number, mostCommonUnitId: Integer, mostCommonValue: Number, numberOfUniqueDailyValues: Number, numberOfChanges: Integer, skewness: Number, kurtosis: Number, latitude: Number, longitude: Number, location: String, createdAt: String, updatedAt: String, outcome: Boolean, sources: String, earliestSourceTime: Integer, latestSourceTime: Integer, earliestMeasurementTime: Integer, latestMeasurementTime: Integer, earliestFillingTime: Integer, latestFillingTime: Integer, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_9] = {
    // create path and map variables
    val path = "/application/userVariables".replaceAll("\\{format\\}","json")

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
   * Get all VariableUserSources
   * Get all VariableUserSources
   * @param accessToken User&#39;s OAuth2 access token
   * @param variableId ID of variable
   * @param timestamp Time that this measurement occurred Uses epoch minute (epoch time divided by 60)
   * @param earliestMeasurementTime Earliest measurement time
   * @param latestMeasurementTime Latest measurement time
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_10
   */
  def applicationVariableUserSourcesGet (accessToken: String, variableId: Integer, timestamp: Integer, earliestMeasurementTime: Integer, latestMeasurementTime: Integer, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_10] = {
    // create path and map variables
    val path = "/application/variableUserSources".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(variableId) != "null") queryParams += "variable_id" -> variableId.toString
    if(String.valueOf(timestamp) != "null") queryParams += "timestamp" -> timestamp.toString
    if(String.valueOf(earliestMeasurementTime) != "null") queryParams += "earliest_measurement_time" -> earliestMeasurementTime.toString
    if(String.valueOf(latestMeasurementTime) != "null") queryParams += "latest_measurement_time" -> latestMeasurementTime.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_10]).asInstanceOf[Inline_response_200_10])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get all Votes
   * Get all Votes
   * @param accessToken User&#39;s OAuth2 access token
   * @param clientId The ID of the client application which last created or updated this vote
   * @param causeId ID of predictor variable
   * @param effectId ID of outcome variable
   * @param value Value of Vote. 1 is for upvote. 0 is for downvote.  Otherwise, there is no vote.
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_11
   */
  def applicationVotesGet (accessToken: String, clientId: String, causeId: Integer, effectId: Integer, value: Integer, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_11] = {
    // create path and map variables
    val path = "/application/votes".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
    if(String.valueOf(causeId) != "null") queryParams += "cause_id" -> causeId.toString
    if(String.valueOf(effectId) != "null") queryParams += "effect_id" -> effectId.toString
    if(String.valueOf(value) != "null") queryParams += "value" -> value.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_11]).asInstanceOf[Inline_response_200_11])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
