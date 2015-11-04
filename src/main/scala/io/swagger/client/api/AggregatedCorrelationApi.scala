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
   * @param correlation correlation
   * @param causeId cause_id
   * @param effectId effect_id
   * @param onsetDelay onset_delay
   * @param durationOfAction duration_of_action
   * @param numberOfPairs number_of_pairs
   * @param valuePredictingHighOutcome value_predicting_high_outcome
   * @param valuePredictingLowOutcome value_predicting_low_outcome
   * @param optimalPearsonProduct optimal_pearson_product
   * @param vote vote
   * @param numberOfUsers number_of_users
   * @param numberOfCorrelations number_of_correlations
   * @param statisticalSignificance statistical_significance
   * @param causeUnit cause_unit
   * @param causeUnitId cause_unit_id
   * @param causeChanges cause_changes
   * @param effectChanges effect_changes
   * @param aggregateQmScore aggregate_qm_score
   * @param createdAt created_at
   * @param updatedAt updated_at
   * @param status status
   * @param errorMessage error_message
   * @param lastSuccessfulUpdateTime last_successful_update_time
   * @param reversePearsonCorrelationCoefficient reverse_pearson_correlation_coefficient
   * @param predictivePearsonCorrelationCoefficient predictive_pearson_correlation_coefficient
   * @param limit limit
   * @param offset offset
   * @param sort sort
   * @return Inline_response_200
   */
  def aggregatedCorrelationsGet (correlation: Number, causeId: Integer, effectId: Integer, onsetDelay: Integer, durationOfAction: Integer, numberOfPairs: Integer, valuePredictingHighOutcome: Number, valuePredictingLowOutcome: Number, optimalPearsonProduct: Number, vote: Number, numberOfUsers: Integer, numberOfCorrelations: Integer, statisticalSignificance: Number, causeUnit: String, causeUnitId: Integer, causeChanges: Integer, effectChanges: Integer, aggregateQmScore: Number, createdAt: String, updatedAt: String, status: String, errorMessage: String, lastSuccessfulUpdateTime: String, reversePearsonCorrelationCoefficient: Number, predictivePearsonCorrelationCoefficient: Number, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200] = {
    // create path and map variables
    val path = "/aggregatedCorrelations".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(correlation) != "null") queryParams += "correlation" -> correlation.toString
    if(String.valueOf(causeId) != "null") queryParams += "cause_id" -> causeId.toString
    if(String.valueOf(effectId) != "null") queryParams += "effect_id" -> effectId.toString
    if(String.valueOf(onsetDelay) != "null") queryParams += "onset_delay" -> onsetDelay.toString
    if(String.valueOf(durationOfAction) != "null") queryParams += "duration_of_action" -> durationOfAction.toString
    if(String.valueOf(numberOfPairs) != "null") queryParams += "number_of_pairs" -> numberOfPairs.toString
    if(String.valueOf(valuePredictingHighOutcome) != "null") queryParams += "value_predicting_high_outcome" -> valuePredictingHighOutcome.toString
    if(String.valueOf(valuePredictingLowOutcome) != "null") queryParams += "value_predicting_low_outcome" -> valuePredictingLowOutcome.toString
    if(String.valueOf(optimalPearsonProduct) != "null") queryParams += "optimal_pearson_product" -> optimalPearsonProduct.toString
    if(String.valueOf(vote) != "null") queryParams += "vote" -> vote.toString
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
   * @param body AggregatedCorrelation that should be stored
   * @return Inline_response_200_1
   */
  def aggregatedCorrelationsPost (body: AggregatedCorrelation) : Option[Inline_response_200_1] = {
    // create path and map variables
    val path = "/aggregatedCorrelations".replaceAll("\\{format\\}","json")

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
   * @return Inline_response_200_1
   */
  def aggregatedCorrelationsIdGet (id: Integer) : Option[Inline_response_200_1] = {
    // create path and map variables
    val path = "/aggregatedCorrelations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
   * @param body AggregatedCorrelation that should be updated
   * @return Inline_response_200_2
   */
  def aggregatedCorrelationsIdPut (id: Integer, body: AggregatedCorrelation) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/aggregatedCorrelations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
   * Delete AggregatedCorrelation
   * Delete AggregatedCorrelation
   * @param id id of AggregatedCorrelation
   * @return Inline_response_200_2
   */
  def aggregatedCorrelationsIdDelete (id: Integer) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/aggregatedCorrelations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
