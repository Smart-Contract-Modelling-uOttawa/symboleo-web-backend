/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo.impl;

import ca.uottawa.csmlab.symboleo.symboleo.NegatedPAtom;
import ca.uottawa.csmlab.symboleo.symboleo.Proposition;
import ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Negated PAtom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.impl.NegatedPAtomImpl#getNegated <em>Negated</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NegatedPAtomImpl extends PropositionImpl implements NegatedPAtom
{
  /**
   * The cached value of the '{@link #getNegated() <em>Negated</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNegated()
   * @generated
   * @ordered
   */
  protected Proposition negated;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NegatedPAtomImpl()
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
    return SymboleoPackage.Literals.NEGATED_PATOM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Proposition getNegated()
  {
    return negated;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNegated(Proposition newNegated, NotificationChain msgs)
  {
    Proposition oldNegated = negated;
    negated = newNegated;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymboleoPackage.NEGATED_PATOM__NEGATED, oldNegated, newNegated);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNegated(Proposition newNegated)
  {
    if (newNegated != negated)
    {
      NotificationChain msgs = null;
      if (negated != null)
        msgs = ((InternalEObject)negated).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.NEGATED_PATOM__NEGATED, null, msgs);
      if (newNegated != null)
        msgs = ((InternalEObject)newNegated).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.NEGATED_PATOM__NEGATED, null, msgs);
      msgs = basicSetNegated(newNegated, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.NEGATED_PATOM__NEGATED, newNegated, newNegated));
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
      case SymboleoPackage.NEGATED_PATOM__NEGATED:
        return basicSetNegated(null, msgs);
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
      case SymboleoPackage.NEGATED_PATOM__NEGATED:
        return getNegated();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SymboleoPackage.NEGATED_PATOM__NEGATED:
        setNegated((Proposition)newValue);
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
      case SymboleoPackage.NEGATED_PATOM__NEGATED:
        setNegated((Proposition)null);
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
      case SymboleoPackage.NEGATED_PATOM__NEGATED:
        return negated != null;
    }
    return super.eIsSet(featureID);
  }

} //NegatedPAtomImpl
