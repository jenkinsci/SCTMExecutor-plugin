<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" indent="yes"/>
  <xsl:template match="//TestSuite">
    <xsl:element name="testsuite">
      <xsl:attribute name="name"><xsl:value-of select="./@TestItem"/></xsl:attribute>
      <xsl:attribute name="time"><xsl:value-of select="./Timer"/></xsl:attribute>
      <xsl:attribute name="tests"><xsl:value-of select="count(.//Test)"/></xsl:attribute>
      <xsl:attribute name="failure"><xsl:value-of select="count(.//Test/Incident)"/></xsl:attribute>
      <xsl:apply-templates/>
    </xsl:element>
  </xsl:template>
  <xsl:template match="*/TestSuite/Test">
    <xsl:element name="testcase">
      <xsl:attribute name="name"><xsl:value-of select="./@TestItem"/></xsl:attribute>
      <xsl:attribute name="time"><xsl:value-of select="./Timer"/></xsl:attribute>
      <xsl:apply-templates/>
    </xsl:element>
  </xsl:template>
  <xsl:template match="*/Test/Incident">
    <xsl:element name="failure">
      <xsl:value-of select="./Message"/>
      <xsl:value-of select="./Detail/Info"/>
    </xsl:element>
  </xsl:template>
</xsl:stylesheet>
