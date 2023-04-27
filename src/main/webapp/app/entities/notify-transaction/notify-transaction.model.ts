import dayjs from 'dayjs/esm';
import { ProccesingStatus } from 'app/entities/enumerations/proccesing-status.model';

export interface INotifyTransaction {
  id: number;
  transactionUId?: number | null;
  recordId?: number | null;
  customerPaymentCode?: string | null;
  schoolName?: string | null;
  sourcePaymentChannelCode?: string | null;
  schoolpayReceiptNumber?: string | null;
  amount?: number | null;
  schoolCode?: string | null;
  partnerCode?: string | null;
  dateCreated?: dayjs.Dayjs | null;
  sourceTransactionId?: number | null;
  studentCode?: number | null;
  studentName?: string | null;
  charges?: number | null;
  timestamp?: dayjs.Dayjs | null;
  narration?: string | null;
  currency?: number | null;
  debitAccount?: number | null;
  creditAccount?: number | null;
  proccessingStatus?: ProccesingStatus | null;
  fcrTransactionStatus?: ProccesingStatus | null;
  fcrTransactionId?: string | null;
  fcrTransactionReference?: string | null;
  freeField1?: string | null;
  freeField2?: string | null;
  freeField3?: string | null;
  retries?: number | null;
}

export type NewNotifyTransaction = Omit<INotifyTransaction, 'id'> & { id: null };
