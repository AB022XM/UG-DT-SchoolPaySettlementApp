import dayjs from 'dayjs/esm';

import { RecordStatus } from 'app/entities/enumerations/record-status.model';
import { DELFLAG } from 'app/entities/enumerations/delflag.model';

import { IPartner, NewPartner } from './partner.model';

export const sampleWithRequiredData: IPartner = {
  id: 86899,
  partnerId: 'c0f41bb7-a93e-4d5e-9e45-9cb25c06f417',
  partnerCode: 12161,
  partnerName: 'Outdoors calculate',
  status: RecordStatus['INACTIVE'],
  isDeleted: DELFLAG['True'],
};

export const sampleWithPartialData: IPartner = {
  id: 14933,
  partnerId: '7f2baf80-0b26-414b-aade-f43019d5a280',
  partnerCode: 58008,
  phonenumber: 'bypass',
  address: 'Assistant Slovenia Planner',
  partnerName: 'Parks',
  status: RecordStatus['ACTIVE'],
  freeField3: 'York RAM',
  isDeleted: DELFLAG['True'],
};

export const sampleWithFullData: IPartner = {
  id: 46629,
  partnerId: '71535a9c-d7b2-4973-bf32-9508bdb66269',
  partnerCode: 47747,
  partnerShortcode: 37583,
  phonenumber: 'Virginia',
  address: 'Sausages Plastic feed',
  partnerName: 'invoice',
  registrationdate: dayjs('2023-04-25'),
  isAbsaPartner: false,
  status: RecordStatus['INACTIVE'],
  freeField1: 'Colorado Nigeria',
  freeField2: 'Dynamic',
  freeField3: 'Isle payment',
  provideDebitAccount: true,
  provideCreditAccount: true,
  isDeleted: DELFLAG['True'],
};

export const sampleWithNewData: NewPartner = {
  partnerId: 'ce2f2f1f-69ec-4388-9a45-e7026c2b9fdc',
  partnerCode: 14745,
  partnerName: 'Account Beauty',
  status: RecordStatus['PENDING'],
  isDeleted: DELFLAG['False'],
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
