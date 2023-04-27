import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IPartner, NewPartner } from '../partner.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IPartner for edit and NewPartnerFormGroupInput for create.
 */
type PartnerFormGroupInput = IPartner | PartialWithRequiredKeyOf<NewPartner>;

type PartnerFormDefaults = Pick<NewPartner, 'id' | 'isAbsaPartner' | 'provideDebitAccount' | 'provideCreditAccount'>;

type PartnerFormGroupContent = {
  id: FormControl<IPartner['id'] | NewPartner['id']>;
  partnerId: FormControl<IPartner['partnerId']>;
  partnerCode: FormControl<IPartner['partnerCode']>;
  partnerShortcode: FormControl<IPartner['partnerShortcode']>;
  phonenumber: FormControl<IPartner['phonenumber']>;
  address: FormControl<IPartner['address']>;
  partnerName: FormControl<IPartner['partnerName']>;
  registrationdate: FormControl<IPartner['registrationdate']>;
  isAbsaPartner: FormControl<IPartner['isAbsaPartner']>;
  status: FormControl<IPartner['status']>;
  freeField1: FormControl<IPartner['freeField1']>;
  freeField2: FormControl<IPartner['freeField2']>;
  freeField3: FormControl<IPartner['freeField3']>;
  provideDebitAccount: FormControl<IPartner['provideDebitAccount']>;
  provideCreditAccount: FormControl<IPartner['provideCreditAccount']>;
  isDeleted: FormControl<IPartner['isDeleted']>;
};

export type PartnerFormGroup = FormGroup<PartnerFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class PartnerFormService {
  createPartnerFormGroup(partner: PartnerFormGroupInput = { id: null }): PartnerFormGroup {
    const partnerRawValue = {
      ...this.getFormDefaults(),
      ...partner,
    };
    return new FormGroup<PartnerFormGroupContent>({
      id: new FormControl(
        { value: partnerRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        }
      ),
      partnerId: new FormControl(partnerRawValue.partnerId, {
        validators: [Validators.required],
      }),
      partnerCode: new FormControl(partnerRawValue.partnerCode, {
        validators: [Validators.required],
      }),
      partnerShortcode: new FormControl(partnerRawValue.partnerShortcode),
      phonenumber: new FormControl(partnerRawValue.phonenumber),
      address: new FormControl(partnerRawValue.address),
      partnerName: new FormControl(partnerRawValue.partnerName, {
        validators: [Validators.required, Validators.minLength(3), Validators.maxLength(100)],
      }),
      registrationdate: new FormControl(partnerRawValue.registrationdate),
      isAbsaPartner: new FormControl(partnerRawValue.isAbsaPartner),
      status: new FormControl(partnerRawValue.status, {
        validators: [Validators.required],
      }),
      freeField1: new FormControl(partnerRawValue.freeField1),
      freeField2: new FormControl(partnerRawValue.freeField2),
      freeField3: new FormControl(partnerRawValue.freeField3),
      provideDebitAccount: new FormControl(partnerRawValue.provideDebitAccount),
      provideCreditAccount: new FormControl(partnerRawValue.provideCreditAccount),
      isDeleted: new FormControl(partnerRawValue.isDeleted, {
        validators: [Validators.required],
      }),
    });
  }

  getPartner(form: PartnerFormGroup): IPartner | NewPartner {
    return form.getRawValue() as IPartner | NewPartner;
  }

  resetForm(form: PartnerFormGroup, partner: PartnerFormGroupInput): void {
    const partnerRawValue = { ...this.getFormDefaults(), ...partner };
    form.reset(
      {
        ...partnerRawValue,
        id: { value: partnerRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */
    );
  }

  private getFormDefaults(): PartnerFormDefaults {
    return {
      id: null,
      isAbsaPartner: false,
      provideDebitAccount: false,
      provideCreditAccount: false,
    };
  }
}
