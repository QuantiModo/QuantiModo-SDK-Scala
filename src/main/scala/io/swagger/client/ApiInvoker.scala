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

package io.swagger.client

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import com.sun.jersey.api.client.config.ClientConfig
import com.sun.jersey.api.client.config.DefaultClientConfig
import com.sun.jersey.api.client.filter.LoggingFilter

import com.sun.jersey.core.util.MultivaluedMapImpl
import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import java.io.File
import java.net.URLEncoder
import javax.ws.rs.core.MediaType

import scala.collection.JavaConverters._
import scala.collection.mutable.HashMap

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.core.JsonGenerator.Feature
import com.fasterxml.jackson.databind._
import com.fasterxml.jackson.annotation._
import com.fasterxml.jackson.databind.annotation.JsonSerialize

object ScalaJsonUtil {
  def getJsonMapper = {
    val mapper = new ObjectMapper()
    mapper.registerModule(new DefaultScalaModule())
    mapper.registerModule(new JodaModule());
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT)
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
    mapper
  }
}

class ApiInvoker(val mapper: ObjectMapper = ScalaJsonUtil.getJsonMapper,
                 httpHeaders: HashMap[String, String] = HashMap(),
                 hostMap: HashMap[String, Client] = HashMap(),
                 asyncHttpClient: Boolean = false,
                 authScheme: String = "",
                 authPreemptive: Boolean = false) {

  var defaultHeaders: HashMap[String, String] = httpHeaders

  def escape(value: String): String = {
    URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")
  }

  def escape(value: Long): String = value.toString
  def escape(value: Double): String = value.toString
  def escape(value: Float): String = value.toString

  def deserialize(json: String, containerType: String, cls: Class[_]) = {
    if (cls == classOf[String]) {
      json match {
        case s: String => {
          if (s.startsWith("\"") && s.endsWith("\"") && s.length > 1) s.substring(1, s.length - 1)
          else s
        }
        case _ => null
      }
    } else {
      containerType.toLowerCase match {
        case "array" => {
          val typeInfo = mapper.getTypeFactory().constructCollectionType(classOf[java.util.List[_]], cls)
          val response = mapper.readValue(json, typeInfo).asInstanceOf[java.util.List[_]]
          response.asScala.toList
        }
        case "list" => {
          val typeInfo = mapper.getTypeFactory().constructCollectionType(classOf[java.util.List[_]], cls)
          val response = mapper.readValue(json, typeInfo).asInstanceOf[java.util.List[_]]
          response.asScala.toList
        }
        case _ => {
          json match {
            case e: String if ("\"\"" == e) => null
            case _ => mapper.readValue(json, cls)
          }
        }
      }
    }
  }

  def serialize(obj: AnyRef): String = {
    if (obj != null) {
      obj match {
        case e: List[_] => mapper.writeValueAsString(obj.asInstanceOf[List[_]].asJava)
        case _ => mapper.writeValueAsString(obj)
      }
    } else null
  }

  def invokeApi(host: String, path: String, method: String, queryParams: Map[String, String], formParams: Map[String, String], body: AnyRef, headerParams: Map[String, String], contentType: String): String = {
    val client = getClient(host)

    val querystring = queryParams.filter(k => k._2 != null).map(k => (escape(k._1) + "=" + escape(k._2))).mkString("?", "&", "")
    val builder = client.resource(host + path + querystring).accept(contentType)
    headerParams.map(p => builder.header(p._1, p._2))
    defaultHeaders.map(p => {
      headerParams.contains(p._1) match {
        case true => // override default with supplied header
        case false => if (p._2 != null) builder.header(p._1, p._2)
      }
    })
    var formData: MultivaluedMapImpl = null
    if(contentType == "application/x-www-form-urlencoded") {
      formData = new MultivaluedMapImpl()
      formParams.map(p => formData.add(p._1, p._2))
    }

    val response: ClientResponse = method match {
      case "GET" => {
        builder.get(classOf[ClientResponse]).asInstanceOf[ClientResponse]
      }
      case "POST" => {
        if(formData != null) builder.post(classOf[ClientResponse], formData)
        else if(body != null && body.isInstanceOf[File]) {
          val file = body.asInstanceOf[File]
          val form = new FormDataMultiPart()
          form.field("filename", file.getName())
          form.bodyPart(new FileDataBodyPart("file", file, MediaType.MULTIPART_FORM_DATA_TYPE))
          builder.post(classOf[ClientResponse], form)
        }
        else {
          if(body == null) builder.post(classOf[ClientResponse], serialize(body))
          else builder.`type`(contentType).post(classOf[ClientResponse], serialize(body))
        }
      }
      case "PUT" => {
        if(formData != null) builder.post(classOf[ClientResponse], formData)
        else if(body == null) builder.put(classOf[ClientResponse], null)
        else builder.`type`(contentType).put(classOf[ClientResponse], serialize(body))
      }
      case "DELETE" => {
        builder.delete(classOf[ClientResponse])
      }
      case _ => null
    }
    response.getStatusInfo().getStatusCode() match {
      case 204 => ""
      case code: Int if (Range(200, 299).contains(code)) => {
        response.hasEntity() match {
          case true => response.getEntity(classOf[String])
          case false => ""
        }
      }
      case _ => {
        val entity = response.hasEntity() match {
          case true => response.getEntity(classOf[String])
          case false => "no data"
        }
        throw new ApiException(
          response.getStatusInfo().getStatusCode(),
          entity)
      }
    }
  }

  def getClient(host: String): Client = {
    hostMap.contains(host) match {
      case true => hostMap(host)
      case false => {
        val client = newClient(host)
        // client.addFilter(new LoggingFilter())
        hostMap += host -> client
        client
      }
    }
  }

  def newClient(host: String): Client = asyncHttpClient match {
    case true => {
      import org.sonatype.spice.jersey.client.ahc.config.DefaultAhcConfig
      import org.sonatype.spice.jersey.client.ahc.AhcHttpClient
      import com.ning.http.client.Realm

      val config: DefaultAhcConfig = new DefaultAhcConfig()
      if (!authScheme.isEmpty) {
        val authSchemeEnum = Realm.AuthScheme.valueOf(authScheme)
        config.getAsyncHttpClientConfigBuilder
          .setRealm(new Realm.RealmBuilder().setScheme(authSchemeEnum)
          .setUsePreemptiveAuth(authPreemptive).build)
      }
      AhcHttpClient.create(config)
    }
    case _ => Client.create()
  }
}

object ApiInvoker extends ApiInvoker(mapper = ScalaJsonUtil.getJsonMapper,
  httpHeaders = HashMap(),
  hostMap = HashMap(),
  asyncHttpClient = false,
  authScheme = "",
  authPreemptive = false)

class ApiException(val code: Int, msg: String) extends RuntimeException(msg)
