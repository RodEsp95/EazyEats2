import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VerifiedrequestComponent } from './verifiedrequest.component';

describe('VerifiedrequestComponent', () => {
  let component: VerifiedrequestComponent;
  let fixture: ComponentFixture<VerifiedrequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VerifiedrequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VerifiedrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
