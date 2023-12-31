/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.Attribute#getAttributeModifier <em>Attribute Modifier</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.Attribute#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.Attribute#getDomainType <em>Domain Type</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject
{
  /**
   * Returns the value of the '<em><b>Attribute Modifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Modifier</em>' containment reference.
   * @see #setAttributeModifier(AttributeModifier)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getAttribute_AttributeModifier()
   * @model containment="true"
   * @generated
   */
  AttributeModifier getAttributeModifier();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.Attribute#getAttributeModifier <em>Attribute Modifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Modifier</em>' containment reference.
   * @see #getAttributeModifier()
   * @generated
   */
  void setAttributeModifier(AttributeModifier value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.Attribute#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Base Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base Type</em>' containment reference.
   * @see #setBaseType(BaseType)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getAttribute_BaseType()
   * @model containment="true"
   * @generated
   */
  BaseType getBaseType();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.Attribute#getBaseType <em>Base Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base Type</em>' containment reference.
   * @see #getBaseType()
   * @generated
   */
  void setBaseType(BaseType value);

  /**
   * Returns the value of the '<em><b>Domain Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain Type</em>' reference.
   * @see #setDomainType(DomainType)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getAttribute_DomainType()
   * @model
   * @generated
   */
  DomainType getDomainType();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.Attribute#getDomainType <em>Domain Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain Type</em>' reference.
   * @see #getDomainType()
   * @generated
   */
  void setDomainType(DomainType value);

} // Attribute
