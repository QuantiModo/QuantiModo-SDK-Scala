/**
 * QuantiModo
 * Welcome to QuantiModo API! QuantiModo makes it easy to retrieve normalized user data from a wide array of devices and applications. [Learn about QuantiModo](https://quantimo.do) or contact us at <api@quantimo.do>.         Before you get started, you will need to: * Sign in/Sign up, and add some data at [https://app.quantimo.do/api/v2/account/connectors](https://app.quantimo.do/api/v2/account/connectors) to try out the API for yourself * Create an app to get your client id and secret at [https://app.quantimo.do/api/v2/apps](https://app.quantimo.do/api/v2/apps) * As long as you're signed in, it will use your browser's cookie for authentication.  However, client applications must use OAuth2 tokens to access the API.     ## Application Endpoints These endpoints give you access to all authorized users' data for that application. ### Getting Application Token Make a `POST` request to `/api/v2/oauth/access_token`         * `grant_type` Must be `client_credentials`.         * `clientId` Your application's clientId.         * `client_secret` Your application's client_secret.         * `redirect_uri` Your application's redirect url.                ## Example Queries ### Query Options The standard query options for QuantiModo API are as described in the table below. These are the available query options in QuantiModo API: <table>            <thead>                <tr>                    <th>Parameter</th>                    <th>Description</th>                </tr>            </thead>            <tbody>                <tr>                    <td>limit</td>                    <td>The LIMIT is used to limit the number of results returned.  So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.</td>                </tr>                <tr>                    <td>offset</td>                    <td>Suppose you wanted to show results 11-20. You'd set the    offset to 10 and the limit to 10.</td>                </tr>                <tr>                    <td>sort</td>                    <td>Sort by given field. If the field is prefixed with '-', it    will sort in descending order.</td>                </tr>            </tbody>        </table>         ### Pagination Conventions Since the maximum limit is 200 records, to get more than that you'll have to make multiple API calls and page through the results. To retrieve all the data, you can iterate through data by using the `limit` and `offset` query parameters.For example, if you want to retrieve data from 61-80 then you can use a query with the following parameters,         `/v2/variables?limit=20&offset=60`         Generally, you'll be retrieving new or updated user data. To avoid unnecessary API calls, you'll want to store your last refresh time locally.  Initially, it should be set to 0. Then whenever you make a request to get new data, you should limit the returned results to those updated since your last refresh by appending append         `?lastUpdated=(ge)&quot2013-01-D01T01:01:01&quot`         to your request.         Also for better pagination, you can get link to the records of first, last, next and previous page from response headers: * `Total-Count` - Total number of results for given query * `Link-First` - Link to get first page records * `Link-Last` - Link to get last page records * `Link-Prev` - Link to get previous records set * `Link-Next` - Link to get next records set         Remember, response header will be only sent when the record set is available. e.g. You will not get a ```Link-Last``` & ```Link-Next``` when you query for the last page.         ### Filter operators support API supports the following operators with filter parameters: <br> **Comparison operators**         Comparison operators allow you to limit results to those greater than, less than, or equal to a specified value for a specified attribute. These operators can be used with strings, numbers, and dates. The following comparison operators are available: * `gt` for `greater than` comparison * `ge` for `greater than or equal` comparison * `lt` for `less than` comparison * `le` for `less than or equal` comparison         They are included in queries using the following format:         `(<operator>)<value>`         For example, in order to filter value which is greater than 21, the following query parameter should be used:         `?value=(gt)21` <br><br> **Equals/In Operators**         It also allows filtering by the exact value of an attribute or by a set of values, depending on the type of value passed as a query parameter. If the value contains commas, the parameter is split on commas and used as array input for `IN` filtering, otherwise the exact match is applied. In order to only show records which have the value 42, the following query should be used:         `?value=42`         In order to filter records which have value 42 or 43, the following query should be used:         `?value=42,43` <br><br> **Like operators**         Like operators allow filtering using `LIKE` query. This operator is triggered if exact match operator is used, but value contains `%` sign as the first or last character. In order to filter records which category that start with `Food`, the following query should be used:         `?category=Food%` <br><br> **Negation operator**         It is possible to get negated results of a query by prefixed the operator with `!`. Some examples:         `//filter records except those with value are not 42 or 43`<br> `?value=!42,43`         `//filter records with value not greater than 21`<br> `?value=!(ge)21` <br><br> **Multiple constraints for single attribute**         It is possible to apply multiple constraints by providing an array of query filters:         Filter all records which value is greater than 20.2 and less than 20.3<br> `?value[]=(gt)20.2&value[]=(lt)20.3`         Filter all records which value is greater than 20.2 and less than 20.3 but not 20.2778<br> `?value[]=(gt)20.2&value[]=(lt)20.3&value[]=!20.2778`<br><br> 
 *
 * OpenAPI spec version: 2.0.6
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.swagger.client.api

import io.swagger.client.model.Variable
import io.swagger.client.model.UserVariables
import io.swagger.client.model.VariableCategory
import io.swagger.client.model.VariablesNew
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class VariablesApi(val defBasePath: String = "https://app.quantimo.do/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  /**
   * Get public variables
   * This endpoint retrieves an array of all public variables. Public variables are things like foods, medications, symptoms, conditions, and anything not unique to a particular user. For instance, a telephone number or name would not be a public variable.
   * @return Variable
   */
  def v1PublicVariablesGet () : Option[Variable] = {
    // create path and map variables
    val path = "/v1/public/variables".replaceAll("\\{format\\}","json")
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
           Some(ApiInvoker.deserialize(s, "", classOf[Variable]).asInstanceOf[Variable])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get top 5 PUBLIC variables with the most correlations
   * Get top 5 PUBLIC variables with the most correlations containing the entered search characters. For example, search for &#39;mood&#39; as an effect. Since &#39;Overall Mood&#39; has a lot of correlations with other variables, it should be in the autocomplete list.&lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;category&lt;/b&gt; - Category of Variable&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param search Search query can be some fraction of a variable name. 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param categoryName Filter variables by category name. The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work. (optional)
   * @param source Specify a data source name to only return variables from a specific data source. (optional)
   * @param effectOrCause Indicate if you only want variables that have user correlations.  Possible values are effect and cause. (optional)
   * @param publicEffectOrCause Indicate if you only want variables that have aggregated correlations.  Possible values are effect and cause. (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. (optional)
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. (optional)
   * @return Variable
   */
  def v1PublicVariablesSearchSearchGet (search: String, accessToken: String, categoryName: String, source: String, effectOrCause: String, publicEffectOrCause: String, limit: Integer, offset: Integer, sort: Integer) : Option[Variable] = {
    // create path and map variables
    val path = "/v1/public/variables/search/{search}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "search" + "\\}",apiInvoker.escape(search))


    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(categoryName) != "null") queryParams += "categoryName" -> categoryName.toString
if(String.valueOf(source) != "null") queryParams += "source" -> source.toString
if(String.valueOf(effectOrCause) != "null") queryParams += "effectOrCause" -> effectOrCause.toString
if(String.valueOf(publicEffectOrCause) != "null") queryParams += "publicEffectOrCause" -> publicEffectOrCause.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Variable]).asInstanceOf[Variable])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Update User Settings for a Variable
   * Users can change the parameters used in analysis of that variable such as the expected duration of action for a variable to have an effect, the estimated delay before the onset of action. In order to filter out erroneous data, they are able to set the maximum and minimum reasonable daily values for a variable.
   * @param userVariables Variable user settings data 
   * @return void
   */
  def v1UserVariablesPost (userVariables: UserVariables)  = {
    // create path and map variables
    val path = "/v1/userVariables".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if (userVariables == null) throw new Exception("Missing required parameter 'userVariables' when calling VariablesApi->v1UserVariablesPost")

        
    
    var postBody: AnyRef = userVariables

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
                  case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Variable categories
   * The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work.
   * @return List[VariableCategory]
   */
  def v1VariableCategoriesGet () : Option[List[VariableCategory]] = {
    // create path and map variables
    val path = "/v1/variableCategories".replaceAll("\\{format\\}","json")
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
           Some(ApiInvoker.deserialize(s, "array", classOf[VariableCategory]).asInstanceOf[List[VariableCategory]])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get variables by the category name
   * Get variables by the category name. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;name&lt;/b&gt; - Original name of the variable (supports exact name match only)&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - Filter by the last time any of the properties of the variable were changed. Uses UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;li&gt;&lt;b&gt;source&lt;/b&gt; - The name of the data source that created the variable (supports exact name match only). So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here&lt;/li&gt;&lt;li&gt;&lt;b&gt;latestMeasurementTime&lt;/b&gt; - Filter variables based on the last time a measurement for them was created or updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;li&gt;&lt;b&gt;numberOfMeasurements&lt;/b&gt; - Filter variables by the total number of measurements that they have. This could be used of you want to filter or sort by popularity.&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastSource&lt;/b&gt; - Limit variables to those which measurements were last submitted by a specific source. So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here. (supports exact name match only)&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param id Common variable id (optional)
   * @param userId User id (optional)
   * @param category Filter data by category (optional)
   * @param name Original name of the variable (supports exact name match only) (optional)
   * @param lastUpdated Filter by the last time any of the properties of the variable were changed. Uses UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot; (optional)
   * @param source The name of the data source that created the variable (supports exact name match only). So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here (optional)
   * @param latestMeasurementTime Filter variables based on the last time a measurement for them was created or updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot; (optional)
   * @param numberOfMeasurements Filter variables by the total number of measurements that they have. This could be used of you want to filter or sort by popularity. (optional)
   * @param lastSource Limit variables to those which measurements were last submitted by a specific source. So if you have a client application and you only want variables that were last updated by your app, you can include the name of your app here. (supports exact name match only) (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. (optional)
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. (optional)
   * @return Variable
   */
  def v1VariablesGet (accessToken: String, id: Integer, userId: Integer, category: String, name: String, lastUpdated: String, source: String, latestMeasurementTime: String, numberOfMeasurements: String, lastSource: String, limit: Integer, offset: Integer, sort: Integer) : Option[Variable] = {
    // create path and map variables
    val path = "/v1/variables".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(id) != "null") queryParams += "id" -> id.toString
if(String.valueOf(userId) != "null") queryParams += "userId" -> userId.toString
if(String.valueOf(category) != "null") queryParams += "category" -> category.toString
if(String.valueOf(name) != "null") queryParams += "name" -> name.toString
if(String.valueOf(lastUpdated) != "null") queryParams += "lastUpdated" -> lastUpdated.toString
if(String.valueOf(source) != "null") queryParams += "source" -> source.toString
if(String.valueOf(latestMeasurementTime) != "null") queryParams += "latestMeasurementTime" -> latestMeasurementTime.toString
if(String.valueOf(numberOfMeasurements) != "null") queryParams += "numberOfMeasurements" -> numberOfMeasurements.toString
if(String.valueOf(lastSource) != "null") queryParams += "lastSource" -> lastSource.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[Variable]).asInstanceOf[Variable])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Create Variables
   * Allows the client to create a new variable in the &#x60;variables&#x60; table.
   * @param body Original name for the variable. 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return void
   */
  def v1VariablesPost (body: VariablesNew, accessToken: String)  = {
    // create path and map variables
    val path = "/v1/variables".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if (body == null) throw new Exception("Missing required parameter 'body' when calling VariablesApi->v1VariablesPost")

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
                  case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get variables by search query
   * Get variables containing the search characters for which the currently logged in user has measurements. Used to provide auto-complete function in variable search boxes.
   * @param search Search query which may be an entire variable name or a fragment of one. 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param categoryName Filter variables by category name. The variable categories include Activity, Causes of Illness, Cognitive Performance, Conditions, Environment, Foods, Location, Miscellaneous, Mood, Nutrition, Physical Activity, Physique, Sleep, Social Interactions, Symptoms, Treatments, Vital Signs, and Work. (optional)
   * @param includePublic Set to true if you would like to include public variables when no user variables are found. (optional)
   * @param manualTracking Set to true if you would like to exlude variables like apps and website names. (optional)
   * @param source Specify a data source name to only return variables from a specific data source. (optional)
   * @param effectOrCause Indicate if you only want variables that have user correlations.  Possible values are effect and cause. (optional)
   * @param publicEffectOrCause Indicate if you only want variables that have aggregated correlations.  Possible values are effect and cause. (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. (optional)
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. (optional)
   * @return List[Variable]
   */
  def v1VariablesSearchSearchGet (search: String, accessToken: String, categoryName: String, includePublic: Boolean, manualTracking: Boolean, source: String, effectOrCause: String, publicEffectOrCause: String, limit: Integer, offset: Integer) : Option[List[Variable]] = {
    // create path and map variables
    val path = "/v1/variables/search/{search}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "search" + "\\}",apiInvoker.escape(search))


    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(categoryName) != "null") queryParams += "categoryName" -> categoryName.toString
if(String.valueOf(includePublic) != "null") queryParams += "includePublic" -> includePublic.toString
if(String.valueOf(manualTracking) != "null") queryParams += "manualTracking" -> manualTracking.toString
if(String.valueOf(source) != "null") queryParams += "source" -> source.toString
if(String.valueOf(effectOrCause) != "null") queryParams += "effectOrCause" -> effectOrCause.toString
if(String.valueOf(publicEffectOrCause) != "null") queryParams += "publicEffectOrCause" -> publicEffectOrCause.toString
if(String.valueOf(limit) != "null") queryParams += "limit" -> limit.toString
if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
    
    
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
           Some(ApiInvoker.deserialize(s, "array", classOf[Variable]).asInstanceOf[List[Variable]])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get info about a variable
   * Get all of the settings and information about a variable by its name. If the logged in user has modified the settings for the variable, these will be provided instead of the default settings for that variable.
   * @param variableName Variable name 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return Variable
   */
  def v1VariablesVariableNameGet (variableName: String, accessToken: String) : Option[Variable] = {
    // create path and map variables
    val path = "/v1/variables/{variableName}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "variableName" + "\\}",apiInvoker.escape(variableName))


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
           Some(ApiInvoker.deserialize(s, "", classOf[Variable]).asInstanceOf[Variable])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

}
