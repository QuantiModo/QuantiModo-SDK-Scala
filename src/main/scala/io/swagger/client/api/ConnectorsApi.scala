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

import io.swagger.client.model.ConnectorInstruction
import io.swagger.client.model.ConnectorInfo
import io.swagger.client.model.Connector
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class ConnectorsApi(val defBasePath: String = "https://app.quantimo.do/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  /**
   * Get embeddable connect javascript
   * Get embeddable connect javascript. Usage:    - Embedding in applications with popups for 3rd-party authentication windows.      Use &#x60;qmSetupInPopup&#x60; function after connecting &#x60;connect.js&#x60;.    - Embedding in applications with popups for 3rd-party authentication windows.      Requires a selector to block. It will be embedded in this block.      Use &#x60;qmSetupOnPage&#x60; function after connecting &#x60;connect.js&#x60;.    - Embedding in mobile applications without popups for 3rd-party authentication.      Use &#x60;qmSetupOnMobile&#x60; function after connecting &#x60;connect.js&#x60;.      if using the MoodiModo Clones, Use &#x60;qmSetupOnIonic&#x60; function after connecting &#x60;connect.js&#x60;. 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return void
   */
  def v1ConnectJsGet (accessToken: String)  = {
    // create path and map variables
    val path = "/v1/connect.js".replaceAll("\\{format\\}","json")
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
                  case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Mobile connect page
   * This page is designed to be opened in a webview.  Instead of using popup authentication boxes, it uses redirection. You can include the user&#39;s access_token as a URL parameter like https://app.quantimo.do/api/v1/connect/mobile?access_token&#x3D;123
   * @param accessToken User OAuth access token 
   * @return void
   */
  def v1ConnectMobileGet (accessToken: String)  = {
    // create path and map variables
    val path = "/v1/connect/mobile".replaceAll("\\{format\\}","json")
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
                  case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Obtain a token from 3rd party data source
   * Attempt to obtain a token from the data provider, store it in the database. With this, the connector to continue to obtain new user data until the token is revoked.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint. 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return void
   */
  def v1ConnectorsConnectorConnectGet (connector: String, accessToken: String)  = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/connect".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))


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
                  case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Connection Instructions
   * Returns instructions that describe what parameters and endpoint to use to connect to the given data provider.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint. 
   * @param parameters JSON Array of Parameters for the request to enable connector. 
   * @param url URL which should be used to enable the connector. 
   * @param usePopup Should use popup when enabling connector 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return void
   */
  def v1ConnectorsConnectorConnectInstructionsGet (connector: String, parameters: String, url: String, usePopup: Boolean, accessToken: String)  = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/connectInstructions".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))


    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(parameters) != "null") queryParams += "parameters" -> parameters.toString
if(String.valueOf(url) != "null") queryParams += "url" -> url.toString
if(String.valueOf(usePopup) != "null") queryParams += "usePopup" -> usePopup.toString
    
    
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
                  case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Connect Parameter
   * Returns instructions that describe what parameters and endpoint to use to connect to the given data provider.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint. 
   * @param displayName Name of the parameter that is user visible in the form 
   * @param key Name of the property that the user has to enter such as username or password Connector (used in HTTP request) 
   * @param placeholder Placeholder hint value for the parameter input tag. 
   * @param _type Type of input field such as those found here http://www.w3schools.com/tags/tag_input.asp 
   * @param usePopup Should use popup when enabling connector 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param defaultValue Default parameter value (optional)
   * @return ConnectorInstruction
   */
  def v1ConnectorsConnectorConnectParameterGet (connector: String, displayName: String, key: String, placeholder: String, _type: String, usePopup: Boolean, accessToken: String, defaultValue: String) : Option[ConnectorInstruction] = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/connectParameter".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))


    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(defaultValue) != "null") queryParams += "defaultValue" -> defaultValue.toString
if(String.valueOf(displayName) != "null") queryParams += "displayName" -> displayName.toString
if(String.valueOf(key) != "null") queryParams += "key" -> key.toString
if(String.valueOf(placeholder) != "null") queryParams += "placeholder" -> placeholder.toString
if(String.valueOf(_type) != "null") queryParams += "type" -> _type.toString
if(String.valueOf(usePopup) != "null") queryParams += "usePopup" -> usePopup.toString
    
    
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
           Some(ApiInvoker.deserialize(s, "", classOf[ConnectorInstruction]).asInstanceOf[ConnectorInstruction])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Delete stored connection info
   * The disconnect method deletes any stored tokens or connection information from the connectors database.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint. 
   * @return void
   */
  def v1ConnectorsConnectorDisconnectGet (connector: String)  = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/disconnect".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))


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
                  case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get connector info for user
   * Returns information about the connector such as the connector id, whether or not is connected for this user (i.e. we have a token or credentials), and its update history for the user.
   * @param connector Lowercase system name of the source application or device. Get a list of available connectors from the /connectors/list endpoint. 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return ConnectorInfo
   */
  def v1ConnectorsConnectorInfoGet (connector: String, accessToken: String) : Option[ConnectorInfo] = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/info".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))


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
           Some(ApiInvoker.deserialize(s, "", classOf[ConnectorInfo]).asInstanceOf[ConnectorInfo])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Sync with data source
   * The update method tells the QM Connector Framework to check with the data provider (such as Fitbit or MyFitnessPal) and retrieve any new measurements available.
   * @param connector Lowercase system name of the source application or device 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return void
   */
  def v1ConnectorsConnectorUpdateGet (connector: String, accessToken: String)  = {
    // create path and map variables
    val path = "/v1/connectors/{connector}/update".replaceAll("\\{format\\}","json").replaceAll("\\{" + "connector" + "\\}",apiInvoker.escape(connector))


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
                  case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * List of Connectors
   * A connector pulls data from other data providers using their API or a screenscraper. Returns a list of all available connectors and information about them such as their id, name, whether the user has provided access, logo url, connection instructions, and the update history.
   * @return List[Connector]
   */
  def v1ConnectorsListGet () : Option[List[Connector]] = {
    // create path and map variables
    val path = "/v1/connectors/list".replaceAll("\\{format\\}","json")
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
           Some(ApiInvoker.deserialize(s, "array", classOf[Connector]).asInstanceOf[List[Connector]])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

}
