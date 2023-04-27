import dayjs from 'dayjs/esm';

import { ProccesingStatus } from 'app/entities/enumerations/proccesing-status.model';

import { INotifyTransaction, NewNotifyTransaction } from './notify-transaction.model';

export const sampleWithRequiredData: INotifyTransaction = {
  id: 9127,
  transactionUId: 16862,
  recordId: 69222,
  customerPaymentCode: 'Principal',
  schoolName: 'drive',
  sourcePaymentChannelCode: 'toolset Account',
  schoolpayReceiptNumber: 'Borders optical',
  amount: 11914,
  partnerCode: 'SSL Shoes blue',
  dateCreated: dayjs('2023-04-24'),
  sourceTransactionId: 3672,
  studentCode: 1038,
  studentName: 'Borders',
  timestamp: dayjs('2023-04-25'),
  narration: 'parse',
  currency: 30701,
  debitAccount: 33888,
  creditAccount: 23540,
};

export const sampleWithPartialData: INotifyTransaction = {
  id: 13935,
  transactionUId: 24099,
  recordId: 29268,
  customerPaymentCode: 'Stream',
  schoolName: 'Small reboot backing',
  sourcePaymentChannelCode: 'enhance Dollar',
  schoolpayReceiptNumber: 'copy Lebanon invoice',
  amount: 68381,
  schoolCode: 'generate',
  partnerCode: 'up Movies Fish',
  dateCreated: dayjs('2023-04-24'),
  sourceTransactionId: 28478,
  studentCode: 97385,
  studentName: 'application deposit JSON',
  timestamp: dayjs('2023-04-24'),
  narration: 'array States',
  currency: 77597,
  debitAccount: 38757,
  creditAccount: 47881,
  fcrTransactionStatus: ProccesingStatus['FAILED'],
  fcrTransactionReference: 'Bedfordshire',
  retries: 0,
};

export const sampleWithFullData: INotifyTransaction = {
  id: 33427,
  transactionUId: 86071,
  recordId: 38589,
  customerPaymentCode: 'Iraq capacitor',
  schoolName: 'Car Plastic',
  sourcePaymentChannelCode: 'Sports Chair',
  schoolpayReceiptNumber: 'Accounts',
  amount: 95643,
  schoolCode: 'Ergonomic',
  partnerCode: 'Future PNG Carolina',
  dateCreated: dayjs('2023-04-25'),
  sourceTransactionId: 46235,
  studentCode: 47773,
  studentName: 'Bedfordshire Soft reintermediate',
  charges: 73140,
  timestamp: dayjs('2023-04-25'),
  narration: 'protocol',
  currency: 88168,
  debitAccount: 31477,
  creditAccount: 26625,
  proccessingStatus: ProccesingStatus['FAILED'],
  fcrTransactionStatus: ProccesingStatus['FAILED'],
  fcrTransactionId: 'invoice hierarchy Rupee',
  fcrTransactionReference: 'Rial mobile',
  freeField1: 'Cotton hacking rich',
  freeField2: 'sensor Intranet',
  freeField3: 'Paradigm',
  retries: 4,
};

export const sampleWithNewData: NewNotifyTransaction = {
  transactionUId: 43175,
  recordId: 90484,
  customerPaymentCode: 'Books Reverse-engineered Facilitator',
  schoolName: 'content syndicate robust',
  sourcePaymentChannelCode: 'Agent Cheese monetize',
  schoolpayReceiptNumber: 'indigo expedite',
  amount: 30009,
  partnerCode: 'Incredible',
  dateCreated: dayjs('2023-04-24'),
  sourceTransactionId: 43190,
  studentCode: 5807,
  studentName: 'Shoes Missouri payment',
  timestamp: dayjs('2023-04-25'),
  narration: 'Liaison Lodge Future',
  currency: 96437,
  debitAccount: 95831,
  creditAccount: 45096,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
