package io.swagger.client.api

import io.swagger.client.model.Inline_response_200_17
import io.swagger.client.model.Number
import io.swagger.client.model.Inline_response_200_18
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
   * @param accessToken User&#39;s OAuth2 access token
   * @param timestamp Time at which correlation was calculated
   * @param userId ID of user that owns this correlation
   * @param correlation Pearson correlation coefficient between cause and effect measurements
   * @param causeId variable ID of the predictor variable for which the user desires correlations
   * @param effectId variable ID of the outcome variable for which the user desires correlations
   * @param onsetDelay User estimated or default time after cause measurement before a perceivable effect is observed
   * @param durationOfAction Time over which the cause is expected to produce a perceivable effect following the onset delay
   * @param numberOfPairs Number of points that went into the correlation calculation
   * @param valuePredictingHighOutcome cause value that predicts an above average effect value (in default unit for predictor variable)
   * @param valuePredictingLowOutcome cause value that predicts a below average effect value (in default unit for predictor variable)
   * @param optimalPearsonProduct Optimal Pearson Product
   * @param vote Vote
   * @param statisticalSignificance A function of the effect size and sample size
   * @param causeUnit Unit of the predictor variable
   * @param causeUnitId Unit ID of the predictor variable
   * @param causeChanges Cause changes
   * @param effectChanges Effect changes
   * @param qmScore QM Score
   * @param error error
   * @param createdAt When the record was first created. Use ISO 8601 datetime format
   * @param updatedAt When the record in the database was last updated. Use ISO 8601 datetime format
   * @param reversePearsonCorrelationCoefficient Correlation when cause and effect are reversed. For any causal relationship, the forward correlation should exceed the reverse correlation
   * @param predictivePearsonCorrelationCoefficient Predictive Pearson Correlation Coefficient
   * @param limit Limit the number of results returned
   * @param offset Records from give Offset
   * @param sort Sort records by given field
   * @return Inline_response_200_17
   */
  def correlationsGet (accessToken: String, timestamp: Integer, userId: Integer, correlation: Number, causeId: Integer, effectId: Integer, onsetDelay: Integer, durationOfAction: Integer, numberOfPairs: Integer, valuePredictingHighOutcome: Number, valuePredictingLowOutcome: Number, optimalPearsonProduct: Number, vote: Number, statisticalSignificance: Number, causeUnit: String, causeUnitId: Integer, causeChanges: Integer, effectChanges: Integer, qmScore: Number, error: String, createdAt: String, updatedAt: String, reversePearsonCorrelationCoefficient: Number, predictivePearsonCorrelationCoefficient: Number, limit: Integer, offset: Integer, sort: String) : Option[Inline_response_200_17] = {
    // create path and map variables
    val path = "/correlations".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_17]).asInstanceOf[Inline_response_200_17])
         
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
   * @param accessToken User&#39;s OAuth2 access token
   * @param body Correlation that should be stored
   * @return Inline_response_200_18
   */
  def correlationsPost (accessToken: String, body: Correlation) : Option[Inline_response_200_18] = {
    // create path and map variables
    val path = "/correlations".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_18]).asInstanceOf[Inline_response_200_18])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Correlation Details
   * Get Correlation
   * @param id id of Correlation
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_18
   */
  def correlationsIdGet (id: Integer, accessToken: String) : Option[Inline_response_200_18] = {
    // create path and map variables
    val path = "/correlations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[Inline_response_200_18]).asInstanceOf[Inline_response_200_18])
         
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
   * @param accessToken User&#39;s OAuth2 access token
   * @param body Correlation that should be updated
   * @return Inline_response_200_2
   */
  def correlationsIdPut (id: Integer, accessToken: String, body: Correlation) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/correlations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
   * Delete Correlation
   * Delete Correlation
   * @param id id of Correlation
   * @param accessToken User&#39;s OAuth2 access token
   * @return Inline_response_200_2
   */
  def correlationsIdDelete (id: Integer, accessToken: String) : Option[Inline_response_200_2] = {
    // create path and map variables
    val path = "/correlations/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))

    

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
