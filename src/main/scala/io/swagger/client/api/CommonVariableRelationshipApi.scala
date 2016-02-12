package io.swagger.client.api

import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200_12
import io.swagger.client.model.Inline_response_200_13
import io.swagger.client.model.CommonVariableRelationship
import io.swagger.client.model.Inline_response_200_2
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class CommonVariableRelationshipApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all CommonVariableRelationships
   * Get all CommonVariableRelationships
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
   * @param strengthScore A value represented to the size of the effect which the predictor appears to have on the outcome.
   * @param strengthLevel Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores.
   * @param upVotes Number of users who feel that there is a plausible causal relationship between the predictor and outcome variables.
   * @param downVotes Number of users who do not feel that there is a plausible causal relationship between the predictor and outcome variables.
   * @param valuePredictingHighOutcome Value for the predictor variable (in it&#39;s default unit) which typically precedes an above average outcome value
   * @param valuePredictingLowOutcome Value for the predictor variable (in it&#39;s default unit) which typically precedes a below average outcome value
   * @param numberOfUsers Number of users whose data was aggregated to obtain this relationship
   * @param dataSource data_source
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned.
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order.
   * @return Inline_response_200_12
   */
  def commonVariableRelationshipsGet (accessToken: String, id: Integer, confidenceLevel: String, confidenceScore: Number, direction: String, durationOfAction: Integer, errorMessage: String, onsetDelay: Integer, outcomeVariableId: Integer, predictorVariableId: Integer, predictorUnitId: Integer, sinnRank: Number, strengthScore: Number, strengthLevel: String, upVotes: Integer, downVotes: Integer, valuePredictingHighOutcome: Number, valuePredictingLowOutcome: Number, numberOfUsers: Integer, dataSource: String, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_12] = {
    // create path and map variables
    val path = "/commonVariableRelationships".replaceAll("\\{format\\}","json")

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
    if(String.valueOf(strengthScore) != "null") queryParams += "strength_score" -> strengthScore.toString
    if(String.valueOf(strengthLevel) != "null") queryParams += "strength_level" -> strengthLevel.toString
    if(String.valueOf(upVotes) != "null") queryParams += "up_votes" -> upVotes.toString
    if(String.valueOf(downVotes) != "null") queryParams += "down_votes" -> downVotes.toString
    if(String.valueOf(valuePredictingHighOutcome) != "null") queryParams += "value_predicting_high_outcome" -> valuePredictingHighOutcome.toString
    if(String.valueOf(valuePredictingLowOutcome) != "null") queryParams += "value_predicting_low_outcome" -> valuePredictingLowOutcome.toString
    if(String.valueOf(numberOfUsers) != "null") queryParams += "number_of_users" -> numberOfUsers.toString
    if(String.valueOf(dataSource) != "null") queryParams += "data_source" -> dataSource.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_12]).asInstanceOf[Inline_response_200_12])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store CommonVariableRelationship
   * Store CommonVariableRelationship
   * @param accessToken User&#39;s OAuth2 access token
   * @param body CommonVariableRelationship that should be stored
   * @return Inline_response_200_13
   */
  def commonVariableRelationshipsPost (accessToken: String, body: CommonVariableRelationship) : Option[Inline_response_200_13] = {
    // create path and map variables
    val path = "/commonVariableRelationships".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_13]).asInstanceOf[Inline_response_200_13])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get CommonVariableRelationship
   * Get CommonVariableRelationship
   * @param id id of CommonVariableRelationship
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_13
   */
  def commonVariableRelationshipsIdGet (id: Integer, accessToken: String) : Option[Inline_response_200_13] = {
    // create path and map variables
    val path = "/commonVariableRelationships/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_13]).asInstanceOf[Inline_response_200_13])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update CommonVariableRelationship
   * Update CommonVariableRelationship
   * @param id id of CommonVariableRelationship
   * @param accessToken User&#39;s OAuth2 access token
   * @param body CommonVariableRelationship that should be updated
   * @return Inline_response_200_2
   */
  def commonVariableRelationshipsIdPut (id: Integer, accessToken: String, body: CommonVariableRelationship) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/commonVariableRelationships/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
   * Delete CommonVariableRelationship
   * Delete CommonVariableRelationship
   * @param id id of CommonVariableRelationship
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_2
   */
  def commonVariableRelationshipsIdDelete (id: Integer, accessToken: String) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/commonVariableRelationships/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
