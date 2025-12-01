#Author: Sihem
Feature: DellHome page

  Scenario: Selectionner un produit
    Given Admin is on homepage
    When Admin mousehover on menu "Ordinateurs et accessoires" and submenu "Ordinateurs portables"
    And Admin click on product "Ordinateurs portables XPS"
    Then Admin is directed to the page "Ordinateurs portables XPS" 
  

  