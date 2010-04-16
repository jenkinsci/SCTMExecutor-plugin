<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
  <xsl:template match="/">
    <xsl:element name="testsuite">
      <!-- xsl:attribute name="name" select="replace(/TestSuite/@TestItem,'(\p{Graph}*)(\\|/)','')"/-->
      <xsl:attribute name="name">
        <xsl:value-of select="/TestSuite/@TestItem"/>
      </xsl:attribute>
      <xsl:attribute name="tests">
        <xsl:value-of select="/TestSuite/RunCount"/>
      </xsl:attribute>
      <xsl:attribute name="failure">
        <xsl:value-of select="/TestSuite/ErrorCount"/>
      </xsl:attribute>
      <xsl:attribute name="error">0</xsl:attribute>
      <xsl:attribute name="skipped">0</xsl:attribute>
      <xsl:attribute name="time">      
        <xsl:choose>
          <xsl:when test="contains(/TestSuite/@TestItem, 'dll')">
            <xsl:value-of select="/TestSuite/Timer"/>
          </xsl:when>
          <xsl:otherwise>
            <xsl:value-of select="number(/TestSuite/Timer) div 1000"/>
          </xsl:otherwise>
        </xsl:choose>
      </xsl:attribute>
      <xsl:apply-templates/>
    </xsl:element>
  </xsl:template>
  
  <xsl:template match="//Test">
    <xsl:element name="testcase">
      <xsl:attribute name="name">
        <xsl:value-of select="./@TestItem"/>
      </xsl:attribute>
      <xsl:variable name="classname">
        <xsl:for-each select="ancestor-or-self::TestSuite">
          <xsl:value-of select="concat(translate(./@TestItem, '.', '_'), '.')"/>
        </xsl:for-each>
        <xsl:for-each select="ancestor-or-self::ResultElement">
          <xsl:value-of select="concat(translate(./@TestItem, '.', '_'), '.')"/>
        </xsl:for-each>
      </xsl:variable>
      <!-- xsl:attribute name="classname" select="replace(substring($classname,0,string-length($classname)),'(\p{Graph}*)(\\|/)','')"/-->
      <xsl:attribute name="classname">
        <xsl:value-of select="substring($classname,0,string-length($classname))"/>
      </xsl:attribute>
      <xsl:attribute name="time">      
        <xsl:choose>
          <xsl:when test="contains(/TestSuite/@TestItem, 'dll')">
            <xsl:value-of select="./Timer"/>
          </xsl:when>
          <xsl:otherwise>
            <xsl:value-of select="number(./Timer) div 1000"/>
          </xsl:otherwise>
        </xsl:choose>
      </xsl:attribute>      
      <xsl:if test="./WasSuccess = 'false'">
        <xsl:element name="failure">
          <xsl:for-each select="./Incident">
            <xsl:value-of select="./Message"/>
            <xsl:value-of select="./Detail/Info"/>
          </xsl:for-each>
        </xsl:element>
      </xsl:if>
    </xsl:element>
  </xsl:template>
</xsl:stylesheet>
