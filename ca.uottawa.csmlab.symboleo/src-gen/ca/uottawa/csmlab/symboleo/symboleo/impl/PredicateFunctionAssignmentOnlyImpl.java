/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo.impl;

import ca.uottawa.csmlab.symboleo.symboleo.OAssignment;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionAssignmentOnly;
import ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate Function Assignment Only</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.impl.PredicateFunctionAssignmentOnlyImpl#getAssignment <em>Assignment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PredicateFunctionAssignmentOnlyImpl extends PredicateFunctionImpl implements PredicateFunctionAssignmentOnly
{
  /**
   * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignment()
   * @generated
   * @ordered
   */
  protected EList<OAssignment> assignment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PredicateFunctionAssignmentOnlyImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SymboleoPackage.Literals.PREDICATE_FUNCTION_ASSIGNMENT_ONLY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<OAssignment> getAssignment()
  {
    if (assignment == null)
    {
      assignment = new EObjectContainmentEList<OAssignment>(OAssignment.class, this, SymboleoPackage.PREDICATE_FUNCTION_ASSIGNMENT_ONLY__ASSIGNMENT);
    }
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SymboleoPackage.PREDICATE_FUNCTION_ASSIGNMENT_ONLY__ASSIGNMENT:
        return ((InternalEList<?>)getAssignment()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SymboleoPackage.PREDICATE_FUNCTION_ASSIGNMENT_ONLY__ASSIGNMENT:
        return getAssignment();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SymboleoPackage.PREDICATE_FUNCTION_ASSIGNMENT_ONLY__ASSIGNMENT:
        getAssignment().clear();
        getAssignment().addAll((Collection<? extends OAssignment>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SymboleoPackage.PREDICATE_FUNCTION_ASSIGNMENT_ONLY__ASSIGNMENT:
        getAssignment().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SymboleoPackage.PREDICATE_FUNCTION_ASSIGNMENT_ONLY__ASSIGNMENT:
        return assignment != null && !assignment.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PredicateFunctionAssignmentOnlyImpl
