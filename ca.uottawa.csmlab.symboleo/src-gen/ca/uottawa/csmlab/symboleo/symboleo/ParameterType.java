/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.ParameterType#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.ParameterType#getDomainType <em>Domain Type</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getParameterType()
 * @model
 * @generated
 */
public interface ParameterType extends EObject
{
  /**
   * Returns the value of the '<em><b>Base Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base Type</em>' containment reference.
   * @see #setBaseType(BaseType)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getParameterType_BaseType()
   * @model containment="true"
   * @generated
   */
  BaseType getBaseType();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.ParameterType#getBaseType <em>Base Type</em>}' containment reference.
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
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getParameterType_DomainType()
   * @model
   * @generated
   */
  DomainType getDomainType();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.ParameterType#getDomainType <em>Domain Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain Type</em>' reference.
   * @see #getDomainType()
   * @generated
   */
  void setDomainType(DomainType value);

} // ParameterType