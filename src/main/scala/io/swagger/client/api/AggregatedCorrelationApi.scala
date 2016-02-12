package io.swagger.client.api

import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200
import io.swagger.client.model.Inline_response_200_1
import io.swagger.client.model.AggregatedCorrelation
import io.swagger.client.model.Inline_response_200_2
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class AggregatedCorrelationApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all AggregatedCorrelations
   * Get all AggregatedCorrelations
   * @param accessToken User&#39;s OAuth2 access token
   * @param correlation Pearson correlation coefficient between cause and effect measurements
   * @param causeId Variable ID of the predictor variable for which the user desires correlations
   * @param effectId Variable ID of the outcome variable for which the user desires correlations
   * @param onsetDelay User estimated (or default number of seconds) after cause measurement before a perceivable effect is observed
   * @param durationOfAction Number of seconds over which the predictor variable event is expected to produce a perceivable effect following the onset delay
   * @param numberOfPairs Number of predictor/outcome data points used in the analysis
   * @param valuePredictingHighOutcome Predictor daily aggregated measurement value that predicts an above average effect measurement value (in default unit for predictor variable)
   * @param valuePredictingLowOutcome Predictor daily aggregated measurement value that predicts a below average effect measurement value (in default unit for outcome variable)
   * @param optimalPearsonProduct Optimal Pearson Product
   * @param numberOfUsers Number of users whose data was used in this aggregation
   * @param numberOfCorrelations Number of correlational analyses used in this aggregation
   * @param statisticalSignificance A function of the effect size and sample size
   * @param causeUnit Abbreviated unit name for the predictor variable
   * @param causeUnitId Unit ID for the predictor variable
   * @param causeChanges Number of times that the predictor time series changes
   * @param effectChanges Number of times that the predictor time series changes
   * @param aggregateQmScore Aggregated QM Score which is directly proportional with the relevance of each predictor or outcome
   * @param createdAt Date at which the analysis was first performed
   * @param updatedAt Date at which the analysis was last updated
   * @param status Indicates whether an analysis is up to date (UPDATED), needs to be updated (WAITING), or had an error (ERROR)
   * @param errorMessage Message describing any problems encountered during the analysis
   * @param lastSuccessfulUpdateTime Last Successful update time
   * @param reversePearsonCorrelationCoefficient Correlation when cause and effect are reversed. For any causal relationship, the forward correlation should exceed the reverse correlation
   * @param predictivePearsonCorrelationCoefficient Predictive Pearson Correlation Coefficient
   * @param limit Limit the number of results returned
   * @param offset Records from give Offset
   * @param sort Sort records by given field
   * @return Inline_response_200
   */
  def aggregatedCorrelationsGet (accessToken: String, correlation: Number, causeId: Integer, effectId: Integer, onsetDelay: Integer, durationOfAction: Integer, numberOfPairs: Integer, valuePredictingHighOutcome: Number, valuePredictingLowOutcome: Number, optimalPearsonProduct: Number, numberOfUsers: Integer, numberOfCorrelations: Integer, statisticalSignificance: Number, causeUnit: String, causeUnitId: Integer, causeChanges: Integer, effectChanges: Integer, aggregateQmScore: Number, createdAt: String, updatedAt: String, status: String, errorMessage: String, lastSuccessfulUpdateTime: String, reversePearsonCorrelationCoefficient: Number, predictivePearsonCorrelationCoefficient: Number, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200] = {
    // create path and map variables
    val path = "/aggregatedCorrelations".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    if(String.valueOf(correlation) != "null") queryParams += "correlation" -> correlation.toString
    if(String.valueOf(causeId) != "null") queryParams += "cause_id" -> causeId.toString
    if(String.valueOf(effectId) != "null") queryParams += "effect_id" -> effectId.toString
    if(String.valueOf(onsetDelay) != "null") queryParams += "onset_delay" -> onsetDelay.toString
    if(String.valueOf(durationOfAction) != "null") queryParams += "duration_of_action" -> durationOfAction.toString
    if(String.valueOf(numberOfPairs) != "null") queryParams += "number_of_pairs" -> numberOfPairs.toString
    if(String.valueOf(valuePredictingHighOutcome) != "null") queryParams += "value_predicting_high_outcome" -> valuePredictingHighOutcome.toString
    if(String.valueOf(valuePredictingLowOutcome) != "null") queryParams += "value_predicting_low_outcome" -> valuePredictingLowOutcome.toString
    if(String.valueOf(optimalPearsonProduct) != "null") queryParams += "optimal_pearson_product" -> optimalPearsonProduct.toString
    if(String.valueOf(numberOfUsers) != "null") queryParams += "number_of_users" -> numberOfUsers.toString
    if(String.valueOf(numberOfCorrelations) != "null") queryParams += "number_of_correlations" -> numberOfCorrelations.toString
    if(String.valueOf(statisticalSignificance) != "null") queryParams += "statistical_significance" -> statisticalSignificance.toString
    if(String.valueOf(causeUnit) != "null") queryParams += "cause_unit" -> causeUnit.toString
    if(String.valueOf(causeUnitId) != "null") queryParams += "cause_unit_id" -> causeUnitId.toString
    if(String.valueOf(causeChanges) != "null") queryParams += "cause_changes" -> causeChanges.toString
    if(String.valueOf(effectChanges) != "null") queryParams += "effect_changes" -> effectChanges.toString
    if(String.valueOf(aggregateQmScore) != "null") queryParams += "aggregate_qm_score" -> aggregateQmScore.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
    if(String.valueOf(status) != "null") queryParams += "status" -> status.toString
    if(String.valueOf(errorMessage) != "null") queryParams += "error_message" -> errorMessage.toString
    if(String.valueOf(lastSuccessfulUpdateTime) != "null") queryParams += "last_successful_update_time" -> lastSuccessfulUpdateTime.toString
    if(String.valueOf(reversePearsonCorrelationCoefficient) != "null") queryParams += "reverse_pearson_correlation_coefficient" -> reversePearsonCorrelationCoefficient.toString
    if(String.valueOf(predictivePearsonCorrelationCoefficient) != "null") queryParams += "predictive_pearson_correlation_coefficient" -> predictivePearsonCorrelationCoefficient.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200]).asInstanceOf[Inline_response_200])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store AggregatedCorrelation
   * Store AggregatedCorrelation
   * @param accessToken User&#39;s OAuth2 access token
   * @param body AggregatedCorrelation that should be stored
   * @return Inline_response_200_1
   */
  def aggregatedCorrelationsPost (accessToken: String, body: AggregatedCorrelation) : Option[Inline_response_200_1] = {
    // create path and map variables
    val path = "/aggregatedCorrelations".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_1]).asInstanceOf[Inline_response_200_1])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get AggregatedCorrelation
   * Get AggregatedCorrelation
   * @param id id of AggregatedCorrelation
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_1
   */
  def aggregatedCorrelationsIdGet (id: Integer, accessToken: String) : Option[Inline_response_200_1] = {
    // create path and map variables
    val path = "/aggregatedCorrelations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_1]).asInstanceOf[Inline_response_200_1])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update AggregatedCorrelation
   * Update AggregatedCorrelation
   * @param id id of AggregatedCorrelation
   * @param accessToken User&#39;s OAuth2 access token
   * @param body AggregatedCorrelation that should be updated
   * @return Inline_response_200_2
   */
  def aggregatedCorrelationsIdPut (id: Integer, accessToken: String, body: AggregatedCorrelation) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/aggregatedCorrelations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
   * Delete AggregatedCorrelation
   * Delete AggregatedCorrelation
   * @param id id of AggregatedCorrelation
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_2
   */
  def aggregatedCorrelationsIdDelete (id: Integer, accessToken: String) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/aggregatedCorrelations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
