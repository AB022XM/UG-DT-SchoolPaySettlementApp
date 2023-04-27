import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { INotifyTransaction, NewNotifyTransaction } from '../notify-transaction.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts INotifyTransaction for edit and NewNotifyTransactionFormGroupInput for create.
 */
type NotifyTransactionFormGroupInput = INotifyTransaction | PartialWithRequiredKeyOf<NewNotifyTransaction>;

type NotifyTransactionFormDefaults = Pick<NewNotifyTransaction, 'id'>;

type NotifyTransactionFormGroupContent = {
  id: FormControl<INotifyTransaction['id'] | NewNotifyTransaction['id']>;
  transactionUId: FormControl<INotifyTransaction['transactionUId']>;
  recordId: FormControl<INotifyTransaction['recordId']>;
  customerPaymentCode: FormControl<INotifyTransaction['customerPaymentCode']>;
  schoolName: FormControl<INotifyTransaction['schoolName']>;
  sourcePaymentChannelCode: FormControl<INotifyTransaction['sourcePaymentChannelCode']>;
  schoolpayReceiptNumber: FormControl<INotifyTransaction['schoolpayReceiptNumber']>;
  amount: FormControl<INotifyTransaction['amount']>;
  schoolCode: FormControl<INotifyTransaction['schoolCode']>;
  partnerCode: FormControl<INotifyTransaction['partnerCode']>;
  dateCreated: FormControl<INotifyTransaction['dateCreated']>;
  sourceTransactionId: FormControl<INotifyTransaction['sourceTransactionId']>;
  studentCode: FormControl<INotifyTransaction['studentCode']>;
  studentName: FormControl<INotifyTransaction['studentName']>;
  charges: FormControl<INotifyTransaction['charges']>;
  timestamp: FormControl<INotifyTransaction['timestamp']>;
  narration: FormControl<INotifyTransaction['narration']>;
  currency: FormControl<INotifyTransaction['currency']>;
  debitAccount: FormControl<INotifyTransaction['debitAccount']>;
  creditAccount: FormControl<INotifyTransaction['creditAccount']>;
  proccessingStatus: FormControl<INotifyTransaction['proccessingStatus']>;
  fcrTransactionStatus: FormControl<INotifyTransaction['fcrTransactionStatus']>;
  fcrTransactionId: FormControl<INotifyTransaction['fcrTransactionId']>;
  fcrTransactionReference: FormControl<INotifyTransaction['fcrTransactionReference']>;
  freeField1: FormControl<INotifyTransaction['freeField1']>;
  freeField2: FormControl<INotifyTransaction['freeField2']>;
  freeField3: FormControl<INotifyTransaction['freeField3']>;
  retries: FormControl<INotifyTransaction['retries']>;
};

export type NotifyTransactionFormGroup = FormGroup<NotifyTransactionFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class NotifyTransactionFormService {
  createNotifyTransactionFormGroup(notifyTransaction: NotifyTransactionFormGroupInput = { id: null }): NotifyTransactionFormGroup {
    const notifyTransactionRawValue = {
      ...this.getFormDefaults(),
      ...notifyTransaction,
    };
    return new FormGroup<NotifyTransactionFormGroupContent>({
      id: new FormControl(
        { value: notifyTransactionRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        }
      ),
      transactionUId: new FormControl(notifyTransactionRawValue.transactionUId, {
        validators: [Validators.required],
      }),
      recordId: new FormControl(notifyTransactionRawValue.recordId, {
        validators: [Validators.required],
      }),
      customerPaymentCode: new FormControl(notifyTransactionRawValue.customerPaymentCode, {
        validators: [Validators.required],
      }),
      schoolName: new FormControl(notifyTransactionRawValue.schoolName, {
        validators: [Validators.required],
      }),
      sourcePaymentChannelCode: new FormControl(notifyTransactionRawValue.sourcePaymentChannelCode, {
        validators: [Validators.required],
      }),
      schoolpayReceiptNumber: new FormControl(notifyTransactionRawValue.schoolpayReceiptNumber, {
        validators: [Validators.required],
      }),
      amount: new FormControl(notifyTransactionRawValue.amount, {
        validators: [Validators.required],
      }),
      schoolCode: new FormControl(notifyTransactionRawValue.schoolCode),
      partnerCode: new FormControl(notifyTransactionRawValue.partnerCode, {
        validators: [Validators.required],
      }),
      dateCreated: new FormControl(notifyTransactionRawValue.dateCreated, {
        validators: [Validators.required],
      }),
      sourceTransactionId: new FormControl(notifyTransactionRawValue.sourceTransactionId, {
        validators: [Validators.required],
      }),
      studentCode: new FormControl(notifyTransactionRawValue.studentCode, {
        validators: [Validators.required],
      }),
      studentName: new FormControl(notifyTransactionRawValue.studentName, {
        validators: [Validators.required],
      }),
      charges: new FormControl(notifyTransactionRawValue.charges),
      timestamp: new FormControl(notifyTransactionRawValue.timestamp, {
        validators: [Validators.required],
      }),
      narration: new FormControl(notifyTransactionRawValue.narration, {
        validators: [Validators.required],
      }),
      currency: new FormControl(notifyTransactionRawValue.currency, {
        validators: [Validators.required],
      }),
      debitAccount: new FormControl(notifyTransactionRawValue.debitAccount, {
        validators: [Validators.required],
      }),
      creditAccount: new FormControl(notifyTransactionRawValue.creditAccount, {
        validators: [Validators.required],
      }),
      proccessingStatus: new FormControl(notifyTransactionRawValue.proccessingStatus),
      fcrTransactionStatus: new FormControl(notifyTransactionRawValue.fcrTransactionStatus),
      fcrTransactionId: new FormControl(notifyTransactionRawValue.fcrTransactionId),
      fcrTransactionReference: new FormControl(notifyTransactionRawValue.fcrTransactionReference),
      freeField1: new FormControl(notifyTransactionRawValue.freeField1),
      freeField2: new FormControl(notifyTransactionRawValue.freeField2),
      freeField3: new FormControl(notifyTransactionRawValue.freeField3),
      retries: new FormControl(notifyTransactionRawValue.retries, {
        validators: [Validators.max(5)],
      }),
    });
  }

  getNotifyTransaction(form: NotifyTransactionFormGroup): INotifyTransaction | NewNotifyTransaction {
    return form.getRawValue() as INotifyTransaction | NewNotifyTransaction;
  }

  resetForm(form: NotifyTransactionFormGroup, notifyTransaction: NotifyTransactionFormGroupInput): void {
    const notifyTransactionRawValue = { ...this.getFormDefaults(), ...notifyTransaction };
    form.reset(
      {
        ...notifyTransactionRawValue,
        id: { value: notifyTransactionRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */
    );
  }

  private getFormDefaults(): NotifyTransactionFormDefaults {
    return {
      id: null,
    };
  }
}
