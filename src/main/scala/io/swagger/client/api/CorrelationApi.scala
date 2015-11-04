package io.swagger.client.api

import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200_7
import io.swagger.client.model.Inline_response_200_8
import io.swagger.client.model.Correlation
import io.swagger.client.model.Inline_response_200_2
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class CorrelationApi(val defBasePath: String = "https://app.quantimo.do/api/v2",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all Correlations
   * Get all Correlations
   * @param timestamp timestamp
   * @param userId user_id
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
   * @param statisticalSignificance statistical_significance
   * @param causeUnit cause_unit
   * @param causeUnitId cause_unit_id
   * @param causeChanges cause_changes
   * @param effectChanges effect_changes
   * @param qmScore qm_score
   * @param error error
   * @param createdAt created_at
   * @param updatedAt updated_at
   * @param reversePearsonCorrelationCoefficient reverse_pearson_correlation_coefficient
   * @param predictivePearsonCorrelationCoefficient predictive_pearson_correlation_coefficient
   * @param limit limit
   * @param offset offset
   * @param sort sort
   * @return Inline_response_200_7
   */
  def correlationsGet (timestamp: Integer, userId: Integer, correlation: Number, causeId: Integer, effectId: Integer, onsetDelay: Integer, durationOfAction: Integer, numberOfPairs: Integer, valuePredictingHighOutcome: Number, valuePredictingLowOutcome: Number, optimalPearsonProduct: Number, vote: Number, statisticalSignificance: Number, causeUnit: String, causeUnitId: Integer, causeChanges: Integer, effectChanges: Integer, qmScore: Number, error: String, createdAt: String, updatedAt: String, reversePearsonCorrelationCoefficient: Number, predictivePearsonCorrelationCoefficient: Number, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_7] = {
    // create path and map variables
    val path = "/correlations".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(timestamp) != "null") queryParams += "timestamp" -> timestamp.toString
    if(String.valueOf(userId) != "null") queryParams += "user_id" -> userId.toString
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
    if(String.valueOf(statisticalSignificance) != "null") queryParams += "statistical_significance" -> statisticalSignificance.toString
    if(String.valueOf(causeUnit) != "null") queryParams += "cause_unit" -> causeUnit.toString
    if(String.valueOf(causeUnitId) != "null") queryParams += "cause_unit_id" -> causeUnitId.toString
    if(String.valueOf(causeChanges) != "null") queryParams += "cause_changes" -> causeChanges.toString
    if(String.valueOf(effectChanges) != "null") queryParams += "effect_changes" -> effectChanges.toString
    if(String.valueOf(qmScore) != "null") queryParams += "qm_score" -> qmScore.toString
    if(String.valueOf(error) != "null") queryParams += "error" -> error.toString
    if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
    if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_7]).asInstanceOf[Inline_response_200_7])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Store Correlation
   * Store Correlation
   * @param body Correlation that should be stored
   * @return Inline_response_200_8
   */
  def correlationsPost (body: Correlation) : Option[Inline_response_200_8] = {
    // create path and map variables
    val path = "/correlations".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_8]).asInstanceOf[Inline_response_200_8])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Correlation
   * Get Correlation
   * @param id id of Correlation
   * @return Inline_response_200_8
   */
  def correlationsIdGet (id: Integer) : Option[Inline_response_200_8] = {
    // create path and map variables
    val path = "/correlations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_8]).asInstanceOf[Inline_response_200_8])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update Correlation
   * Update Correlation
   * @param id id of Correlation
   * @param body Correlation that should be updated
   * @return Inline_response_200_2
   */
  def correlationsIdPut (id: Integer, body: Correlation) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/correlations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
   * Delete Correlation
   * Delete Correlation
   * @param id id of Correlation
   * @return Inline_response_200_2
   */
  def correlationsIdDelete (id: Integer) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/correlations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
