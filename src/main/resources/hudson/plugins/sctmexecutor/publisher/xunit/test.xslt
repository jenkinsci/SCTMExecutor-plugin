<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:xs="http://www.w3.org/2001/XMLSchema" 
    xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="text" version="1.0" encoding="UTF-8" indent="yes"/>
	  
  <xsl:template match="/TestSuite//TestSuite">
    <xsl:call-template name="rec">
      <xsl:with-param name="in" select="../@TestItem"/>
      <xsl:with-param name="root" select="."/>
    </xsl:call-template>
  </xsl:template>
  
  <xsl:template name="rec">
    <xsl:param name="in"/>
    <xsl:param name="root"/>
    <xsl:param name="out" select="concat($in,'.',$root/@TestItem),'*'"/>
    <xsl:value-of select="$out"/>
    <xsl:call-template name="rec">
      <xsl:with-param name="in" select="$out"/>
      <xsl:with-param name="root" select="$root/TestSuite"/>
    </xsl:call-template>
  </xsl:template>
	
</xsl:stylesheet>
