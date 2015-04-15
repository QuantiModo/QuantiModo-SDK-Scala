package io.swagger.client.model

import io.swagger.client.model.Number



case class Correlation (
  /* Pearson correlation coefficient between cause and effect measurements */
  correlationCoefficient: Number,
  /* ORIGINAL variable name of the cause variable for which the user desires correlations. */
  cause: String,
  /* ORIGINAL variable name of the effect variable for which the user desires correlations. */
  effect: String,
  /* User estimated or default time after cause measurement before a perceivable effect is observed */
  onsetDelay: Double,
  /* Time over which the cause is expected to produce a perceivable effect following the onset delay */
  durationOfAction: Number,
  /* Number of points that went into the correlation calculation */
  numberOfPairs: Number,
  /* Magnitude of the effects of a cause indicating whether it's practically meaningful. */
  effectSize: String,
  /* A function of the effect size and sample size */
  statisticalSignificance: String,
  /* Time at which correlation was calculated */
  timestamp: Number,
  /* Correlation when cause and effect are reversed. For any causal relationship, the forward correlation should exceed the reverse correlation. */
  reverseCorrelation: Number,
  /*  */
  causalityFactor: Number,
  /* Variable category of the cause variable. */
  causeCategory: String,
  /* Variable category of the effect variable. */
  effectCategory: String)
  
